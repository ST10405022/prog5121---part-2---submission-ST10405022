package login;
import javax.swing.*;
/**
 * @author Fungho Baloyi - ST10405022
 *
 */
public class Login {
    private String userName;//declared instance of userName when object is declared in front-end
    private String passWord;//declared instance of passWord when object is declared in front-end
    private String firstName;//declared instance of firstName when object is declared in front-end
    private String lastName;//declared instance of lastName when object is declared in front-end
    private String userName1;//stores userName after registration
    private String passWord1;//stores userName after registration
    private String firstName1;//stores userName after registration
    private String lastName1;//stores userName after registration
    private boolean isUnder = false;//boolean to search for an underscore in userName
    private boolean isSpecial = false;//boolean to search for an underscore in passWord
    private boolean isNumber = false;//boolean to search for an underscore in passWord
    private boolean isUpper = false;//boolean to search for an underscore in passWord
    
    public Login()//default constructor
    {
        userName = "";
        passWord = "";
        firstName = "";
        lastName = "";
    }
    
    public Login(String userName, String passWord, String firstName, String lastName)//parametirized constructor
    {
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public boolean checkUserName()
    {
        int userLength = userName.length();//sets length of userName to this local variable
        boolean underscore = false;
        for(int i = 0; i < userLength;i++)
        {
            char current = userName.charAt(i);
            if((int)current == 95)
            {
                underscore = true;//if underscore("_" or ASCII #95) exists in username then set to true.
            }
        }
        this.isUnder=underscore;//boolean isUnder is set to underscore.
        return this.isUnder && userLength <= 5;//returns true if there is an underscore and no more than 5 characters. 
    }
    
    public boolean checkPasswordComplexity()
    {
        int passLength = passWord.length();
        for(int i = 0; i < passLength;i++)
        {
            int current = passWord.charAt(i);//variable to iterate through the characters in the string
            if(Character.isUpperCase(current))
            {
                isUpper = true;//sets true if an uppercase is in the password string
            }
            else if(Character.isDigit(current))
            {
                isNumber = true;//sets true if a number is in the password string
            }

            else if(((int)current >= 33 && (int)current <= 47) || //Checks whether character is part of the special characters in the ASCII table
                    ((int)current >= 58 && (int)current <=64) || //the string type characters are converted to decimal value of ASCII table.
                    ((int)current >= 91 && (int)current <= 96 || 
                    ((int)current >= 123 && (int)current <=126)))
            {
                isSpecial = true;//sets true if a special character is in the password string
            }
        }
        
        return (passLength >= 8 && isUpper && isNumber && isSpecial);//returns true if password is at least 8 characters, has an uppercase,number and special character
    }
    
    public String registerUser()
    {      
        boolean user = checkUserName();//sets local boolean variable to class method
        if(user == true)
        { 
            boolean pass = checkPasswordComplexity();//sets local boolean variable to class method
            if(pass)
            {
                store();
                return "Username successfully captured.\n"+"Password successfully captured.";//returns this statement if both username and password are valid
            }
            else
                return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";//returns this statement if only username is valid but not password
        }
        
        else
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";//returns this statement if username is not valid
    }
    
    public boolean loginUser()
    {
        return (userName.equals(userName1) && passWord.equals(passWord1));//login is successful if username and password entered match what is stored. 
    }
    
    public String returnLoginStatus()
    {
        if(loginUser() && checkPasswordComplexity() && checkUserName())
        {
            return "Login Successful - Welcome " + firstName + " ," + lastName + " it is great to see you again.";//returns this statement if login is valid
        }
        
        else
        {
            return "Login Failed - Username or password incorrect, please try again";//returns this statement if login does not match registration
        }
    }
    
    //HELPER FUNCTIONS
    
    private void store()//method to store registration upon entry as login details - cannot be accessed outside of the back-end Login Class
    {
        this.userName1 = userName;
        this.passWord1 = passWord;
        this.firstName1 = firstName;
        this.lastName1 = lastName;
    }
    
    public void setUser(String userName)
    {
        this.userName = userName;//sets class instance variable userName to instance passed by object in front-end
    }
        
    public String getUser()
    {
        return this.userName;//returns class instance variable userName to be used by front-end class
    }
    
    public void setPass(String passWord)
    {
        this.passWord = passWord;//sets class instance variable passWord to instance passed by object in front-end
    }
    
    public String getPass()
    {
        return this.passWord;//returns class instance variable passWord to be used by front-end class
    }
    
    public void setFirst(String firstName)
    {
        this.firstName = firstName;//sets class instance variable firstName to instance passed by object in front-end.
    }
    
    public String getFirst()
    {
        return this.firstName;//returns class instance variable firstName to be used by front-end class
    }
    
    public void setLast(String lastName)
    {
        this.lastName = lastName;//sets class instance variable lastName to instance passed by object in front-end.
    }

    public String getLast()
    {
        return this.lastName;//returns class instance variable lastName to be used by front-end class
    }
}
