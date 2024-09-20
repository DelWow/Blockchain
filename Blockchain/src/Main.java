import java.util.*;
import com.google.gson.GsonBuilder;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;

    public static void main(String args[]){


        blockchain.add(new Block(("Hi im the first block"), "0"));
        System.out.println("Mining block 1...");
        blockchain.get(0).mineBlock(difficulty);

        for (int k = 1; k < 9; k++){
            int blockId = k+1;
            blockchain.add(new Block(("Hey im the " + blockId + " block"), blockchain.get(blockchain.size()-1).hash));
            System.out.println("Mining block "+ blockId + "...");
            blockchain.get(k).mineBlock(difficulty);
        }

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);

    }

    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0','0');

        //looping through blockchain to check hashes
        for (int i = 1; i < blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.println("Current Hashses not equal");
                return false;
            }

            //Compare the registered hash with the calculated hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous Hashes not equal");
                return false;
            }

            //check if hash is solved
            if(!currentBlock.hash.substring(0, difficulty).equals(hashTarget)){
                System.out.println("Block has not been mined");
                return false;
            }

        }
        return true;
    }
}
