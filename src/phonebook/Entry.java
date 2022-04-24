package phonebook;

public class Entry extends Person {
    private  String address;
    private  String workNum;
    private  String privateNum;

    public Entry(String ln, String fn, String nn, String addr, String wnum, String pnum) {
        super(ln, fn, nn);
        address = addr;
        workNum = wnum;
        privateNum = pnum;

    }

    public String toString() {

        return super.toString() + "\n   Cím: " + address + "\n   Privát szám: " + privateNum + "\n   Munkahely szám: " + workNum + "\n=================";
    }
    /**
     * Ez az a fuggvény ami a rekodrdot olyanra formázza ,hogy fájlba irható legyen.
     * ","-vel választja el paramétereket. CSV formátumba lesz fájlba írva.
     * @param nincs
     * @return lastname.firstname,ninckname,address,worknumber,privatenumber
     */
    public String toFile() {
        return super.getLastName() + "," + super.getFirstName() + "," + super.getNickname() + "," + address + "," + workNum + "," + privateNum;
    }
    
    
    public String getPrivateNum() {return privateNum;}

    public String getWorkNum() {return workNum;}

    public String getAddress() {return address;}

    public void setAddress(String addr) {address = addr;}

    public void setWorkNum(String wnum) {workNum =wnum;}

    public void setPrivateNum(String pnum) {privateNum =pnum;}


}
