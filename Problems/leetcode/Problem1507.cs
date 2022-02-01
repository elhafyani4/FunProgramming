public class Problem1507 {
    public string ReformatDate(string date) {
       
        string[] datePart = date.Split(" ");
        string day = parseDay(datePart[0]);
        string month = parseMonth(datePart[1]);
        string year = datePart[2];
        
        return $"{year}-{month}-{day}";
    }
    
    private string parseDay(string str)
    {
        string daystr = str[0] + ""; 
        if(Char.IsDigit(str[1]))
        {
            daystr += str[1];
            return daystr;
        }
        
        daystr = "0" + daystr;
        return daystr;
    }
    
    private string parseMonth(string str)
    {
        switch(str)
        {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";            
        }
        
        return string.Empty;
    }
}