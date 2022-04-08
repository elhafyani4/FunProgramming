#!/usr/bin/node

// class to represent directory model.
class directory {

    constructor(name) {
        if (name === "" || name === null) {
            throw new Exception("name can't be empty");
        }

        this.name = name;
        this.subdirectories = new Map();
    }

    containsDirectory = function (dirName) {
        return this.subdirectories.has(dirName);
    };

    getSubdirectory = function (dirname) {
        return this.subdirectories.get(dirname);
    };

    addSubdirectory = function (directory) {
        this.subdirectories.set(directory.name, directory);
    };

    removeSubdriectory = function (dirname) {
        this.subdirectories.delete(dirname.name);
    };
}

// class that represent directory manager.
class directoryManager {
    constructor() {
        this.rootDirectory = new directory("root");
    }

    // function that create a directory.
    createDir = function (dirPath) {
        if (dirPath === "" || dirPath === null) {
            throw new Exception("dirPath can't be empty");
        }

        let currentDirectory = this.rootDirectory;
        let directoryPathParts = utility.splitPath(dirPath);

        for (let i = 0; i < directoryPathParts.length; i++) {
            let pathPart = directoryPathParts[i];
            if (currentDirectory.containsDirectory(directoryPathParts[i])) {
                currentDirectory = currentDirectory.getSubdirectory(pathPart);
                continue;
            }

            let newDir = new directory(pathPart);
            currentDirectory.addSubdirectory(newDir);
            currentDirectory = newDir;
        }
    };

    // function that list directories.
    listDir = function () {
        let directoryStack = [];
        let root = this.rootDirectory;

        let sortedDirectory = Array.from(root.subdirectories.values()).sort(utility.sortString);

        for (let i = 0; i < sortedDirectory.length; i++) {
            directoryStack.push([0, sortedDirectory[i]]);
        }

        while (directoryStack.length > 0) {
            let levelDir = directoryStack.pop();

            console.log(`${utility.insertTab(levelDir[0])}${levelDir[1].name}`);

            sortedDirectory = Array.from(levelDir[1].subdirectories.values()).sort(utility.sortString);

            for (let i = 0; i < sortedDirectory.length; i++) {
                directoryStack.push([levelDir[0] + 1, sortedDirectory[i]]);
            }
        };
    }

    // function that delete specified directory.
    deleteDir = function (dirPath) {
        if (dirPath === "" || dirPath === null) {
            throw new Exception("dirPath can't be empty");
        }

        let currentDirectory = this.rootDirectory;
        let parentDirectory = null;
        let directoryPathParts = utility.splitPath(dirPath);

        for (let i = 0; i < directoryPathParts.length; i++) {
            let directoryPathPart = directoryPathParts[i];
            if (!currentDirectory.containsDirectory(directoryPathParts[i])) {
                console.log(`Cannot delete ${dirPath} - ${directoryPathPart} does not exist`);
                return;
            }

            parentDirectory = currentDirectory;
            currentDirectory = currentDirectory.getSubdirectory(directoryPathPart);
        }

        parentDirectory.removeSubdriectory(currentDirectory);
    }

    // function that move a directory to a specified directory.
    moveDir = function (sourceDir, targetDir) {
        if (sourceDir === "" || sourceDir === null) {
            throw new Exception("sourceDir can't be empty");
        }

        if (targetDir === "" || targetDir === null) {
            throw new Exception("targetDir can't be empty");
        }

        this._pasteDirectory(targetDir, this._cutDir(sourceDir));
    }

    // internal function that get reference to source directory and remove the directory from the parent.
    _cutDir = function (sourceDir) {
        let currentDirectory = this.rootDirectory;
        let parentDirectory = null;
        let pathParts = utility.splitPath(sourceDir);

        for (let i = 0; i < pathParts.length; i++) {
            let pathPart = pathParts[i];
            if (!currentDirectory.containsDirectory(pathParts[i])) {
                console.log(`Cannot find source directory ${sourceDir}.`);
                return;
            }

            parentDirectory = currentDirectory;
            currentDirectory = currentDirectory.getSubdirectory(pathPart);
        }

        parentDirectory.removeSubdriectory(currentDirectory);
        return currentDirectory;
    }

    _pasteDirectory = function (targetDir, directory) {
        let currentDirectory = this.rootDirectory;
        let pathParts = utility.splitPath(targetDir);

        for (let i = 0; i < pathParts.length; i++) {
            let pathPart = pathParts[i];
            if (!currentDirectory.containsDirectory(pathParts[i])) {
                console.log(`Cannot find source directory ${sourceDir}.`);
                return;
            }

            currentDirectory = currentDirectory.getSubdirectory(pathPart);
        }
        currentDirectory.addSubdirectory(directory);
    }
}

// Util class
class utility {
    static splitPath = (dirPath) => {
        return dirPath.split("/");
    };

    static sortString = (a, b) => {
        const upper_a = a.name.toUpperCase();
        const upper_b = b.name.toUpperCase();

        if (upper_b < upper_a) return -1;
        if (upper_b > upper_a) return 1;
        return 0;
    };

    static insertTab(level) {
        return "  ".repeat(level);
    }
}

function main(data)
{
    let dm = new directoryManager();
    let commands = data.split("\n");
    for (let i = 0; i < commands.length; i++) {
        let commandParts = commands[i].split(" ");
        console.log(commands[i]);

        switch (commandParts[0]) {
            case "CREATE":
                dm.createDir(commandParts[1]);
                break;
            case "DELETE":
                dm.deleteDir(commandParts[1]);
                break;
            case "LIST":
                dm.listDir();
                break;
            case "MOVE":
                dm.moveDir(commandParts[1], commandParts[2]);
                break;
            default:
                console.log("Unknown command.");
        }
    }
}

const sampleData = `CREATE fruits
CREATE vegetables
CREATE grains
CREATE fruits/apples
CREATE fruits/apples/fuji
LIST
CREATE grains/squash
MOVE grains/squash vegetables
CREATE foods
MOVE grains foods
MOVE fruits foods
MOVE vegetables foods
LIST
DELETE fruits/apples
DELETE foods/fruits/apples
LIST`;

main(sampleData);
