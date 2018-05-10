import java.util.ArrayList;
/**
 * Created by Dulfrey
 */
public class Blockchain {

	ArrayList<Block> blocks = new ArrayList<>();
	
	
	public Blockchain() {
		String[] genesisTransactions = {"Block genesis","a satoshi sent dulfrey 999900 bitcoin","hal finney sent 10 bitcoins to ivan"};
		Block genesisBlock = new Block(0, genesisTransactions);
		blocks.add(genesisBlock);
	}
	
	public ArrayList<Block> getBlocks() {
		return this.blocks;
	}
	
	
	private  void printBlockchain() {
        for (int i = 0; i < getBlocks().size(); i++) {
        	for (int j = 0; j < getBlocks().get(i).getTransaction().length; j++) {
        		System.out.println(getBlocks().get(i).getTransaction()[j]);
        	}
        	System.out.print("Hash: ");
        	System.out.println(getBlocks().get(i).getBlockHash());
        	System.out.println();
		}		
	}

	private Block  addBlock(String[] block2Transactions) {
		Block genesisBlock = this.blocks.get(blocks.size()-1); 
		Block block2 = new Block(genesisBlock.getBlockHash(), block2Transactions);
		blocks.add(block2);
		return block2;
	}
	
	public static void main(String[] args) {

		Blockchain blockchain = new Blockchain();
		
		String[] block2Transactions = {"block 2","ivan sent 1000 bitcoin to satoshi", "05/05/2018"};
		Block block2 = blockchain.addBlock(block2Transactions);   
        
        String[] block3Transactions = {"block 3","dulfrey sent 999 bitcoin to my satochi", "10/05/2018"};
        Block block3 = blockchain.addBlock(block3Transactions);
       
        blockchain.printBlockchain();
        
	}


}
