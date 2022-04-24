package phonebook;

abstract class Person {
    private  String LastName;
    private  String FirstName;
    private String Nickname;

    public Person(String ln, String fn, String nn) {
        LastName = ln;
        FirstName = fn;
        Nickname = nn;
    }



    public String toString() {
        return "Név: " + LastName + " " + FirstName + "\n" + "   Bece név: " + Nickname;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setNickname(String nn){ Nickname = nn;}

    public void  setLastName(String ln){LastName = ln;}

    public void setFirstName(String fn){ FirstName = fn;}
}
