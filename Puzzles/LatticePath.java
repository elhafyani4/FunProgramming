package Puzzles;

public class LatticePath {


    public static CellNode rootNode = new CellNode();

    public static int gridColumn = 5;
    public static int gridRow = 5;

    public static void main(String[] args) {

        for (int i = 1; i <= gridRow; i++) {
            CellNode cell;

            if (i == 1) {
                cell = rootNode;
            } else {
                cell = new CellNode();
            }

            cell.col = 1;
            cell.row = i;
            cell.data = 1;

            if (i == 1) {
                cell.cellNodeTop = null;
                cell.data = 1;
            }

            cell.cellNodeRight = createRightNode(1, i);

        }

        CellNode celn = getNode(16, 17);
        System.out.println(celn.data);

    }


    public static CellNode createRightNode(int currentCol, int currentRow) {
        CellNode cell = new CellNode();
        cell.col = currentCol + 1;
        cell.row = currentRow;

        if (currentCol == 1) {
            cell.cellNodeLeft = null;
            cell.data = 1;
        } else if (currentRow == 1) {
            cell.cellNodeTop = null;
            cell.data = 1;
        } else {
            if (currentCol + 1 < gridColumn) {
                int tempRow = currentRow - 1;
                int tempCol = currentCol + 1;
                int cellValue = 0;
                while (tempCol >= 1 && tempCol <= gridColumn) {
                    cellValue += getNode(tempCol, tempRow).data;
                    tempCol--;
                }

                getNode(currentCol + 1, currentRow - 1).cellNodeBottom = cell;
                cell.data = cellValue;
            }
        }

        if (currentCol < gridColumn) {
            cell.cellNodeRight = createRightNode(currentCol + 1, currentRow);
            return cell;
        } else {
            return null;
        }
    }


    public static CellNode getNode(int col, int row) {
        CellNode tempNode = rootNode;
        while (col != tempNode.col) {
            tempNode = tempNode.cellNodeRight;
        }
        while (row != tempNode.row) {
            tempNode = tempNode.cellNodeBottom;
        }
        return tempNode;
    }
}

