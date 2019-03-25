package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail = "";
    private int selection;
    private String depChoice;
    private int defaultPasswordLength = 8;
    private String companySuffix;
    Scanner menuInput = new Scanner(System.in);



    public Email()
    {
        System.out.print("Enter your first name: ");
        setFirstName(menuInput.nextLine());
        System.out.print("Enter your last name: ");
        setLastName(menuInput.nextLine());

        System.out.println("Email created: " + getFirstName() + " " + getLastName());

        System.out.print("Enter company name: ");
        String s = menuInput.nextLine();
        companySuffix = s.replaceAll("\\s+","") + ".com";

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("\nYour password is: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix.toLowerCase();
    }

    private String setDepartment()
    {
        System.out.println("\nDepartment codes:");
        System.out.println("1 for Sales");
        System.out.println("2 for Development");
        System.out.println("3 for Accounting");
        System.out.println("0 for Other");
        System.out.print("Enter department code: ");

        selection = Integer.parseInt(menuInput.nextLine());

        switch (selection)
        {
            case 1:
                depChoice = "sales";
                break;

            case 2:
                depChoice = "dev";
                break;

            case 3:
                depChoice = "acc";
                break;

            case 0:
                depChoice = "company";
                break;

            default:
                depChoice = "\nInvalid choice\n";
                System.out.println(depChoice);
                setDepartment();
                break;
        }
        return depChoice;
    }

    public void showInfo()
    {
        System.out.println("\nDisplay name: " + firstName + " " + lastName +
                "\nCompany email: " + email +
                "\nMailbox capacity: " + mailboxCapacity + "mb");
        if(alternateEmail.length() > 1)
            System.out.println("Alternate email: " + getAlternateEmail());
        else
            ;
    }

    public void additionalSetting()
    {
        System.out.println("\nOptions:");
        System.out.println("1 - Change mailbox capacity");
        System.out.println("2 - Change alternate email");
        System.out.println("3 - Change password");
        System.out.println("4 - Change department");
        System.out.println("5 - Show account info");
        System.out.println("0 - Quit");
        System.out.print("Enter number: ");

        selection = Integer.parseInt(menuInput.nextLine());

        switch (selection)
        {
            case 1:
                changeMailboxCapacity();
                additionalSetting();
                break;

            case 2:
                changeAlternateEmail();
                additionalSetting();
                break;

            case 3:
                changePassword();
                additionalSetting();
                break;

            case 4:
                setDepartment();
                additionalSetting();
                break;

            case 5:
                showInfo();
                additionalSetting();
                break;

            case 0:
                System.out.println("Have a good day.");
                System.exit(0);

            default:
                System.out.println("\nInvalidChoice\n");
                additionalSetting();
        }
    }


    private String randomPassword(int length)
    {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i < length; i++)
        {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setFirstName(String f_name)
    {
        this.firstName = f_name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String l_name)
    {
        this.lastName = l_name;
    }

    public String getLastName()
    {
        return lastName;
    }


    public void changeMailboxCapacity()
    {
        System.out.print("Insert new mailbox capacity(500-1024): ");
        setMailboxCapacity(Integer.parseInt(menuInput.nextLine()));
        if(getMailboxCapacity() >= 500 && getMailboxCapacity() <= 1024)
            System.out.println("\nYour new mailbox capacity is " + mailboxCapacity + "mb.");
        else
        {
            System.out.println("\nInvalid mailbox capacity.");
            changeMailboxCapacity();
        }

    }

    public void changeAlternateEmail()
    {
        System.out.print("Insert new alternate email: ");
        String s = menuInput.nextLine();
        setAlternateEmail(s);
        if(s.length() < 1)
            System.out.println("\nThere is no alternate email.");
        else
            System.out.println("\nYour alternate email is " + alternateEmail);
    }

    public void changePassword()
    {
        System.out.print("Insert new password(8-16 characters): ");
        String s = menuInput.nextLine();
        setPassword(s);
        if(getPassword().length() >= 8 && getPassword().length() <= 16)
            System.out.println("\nYou successfully changed your password.");
        else if(getPassword().length() < 8)
        {
            System.out.println("\nPassword too short.");
            changePassword();
        }
        else if(getPassword().length() > 16)
        {
            System.out.println("\nPassword too long.");
            changePassword();
        }
    }

    public void setMailboxCapacity(int capacity)
    {
        this.mailboxCapacity = capacity;
    }

    public int getMailboxCapacity()
    {
        return mailboxCapacity;
    }

    public void setAlternateEmail(String altEmail)
    {
        this.alternateEmail = altEmail;
    }

    public String getAlternateEmail()
    {
        return alternateEmail;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
}
