import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // Date will be a simple message
    private long timeStamp; //number of milliseconds since 1970
    private int TokenId;

    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); //Making sure we do this after setting the other values first.
    }

    public String calculateHash(){
        String calculatedhash = StringUtil.applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(TokenId) + data);
        return calculatedhash;
    }

    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0','0'); //Creates substring with a difficulty * 0
        while(!hash.substring(0, difficulty).equals(target)){
            TokenId++;
            hash = calculateHash();
        }
        System.out.println("Block has been Mined : " + hash);
    }
}
