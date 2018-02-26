package noobchain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.GsonBuilder;

public class NoobChain {

	public static List<Block> blockChain = new ArrayList<>();
	public static void main(String[] args) {
		blockChain.add(new Block("0", "Hi im the first block"));
		blockChain.add(new Block(blockChain.get(blockChain.size()-1).hash, "Yo im the second Block"));
		blockChain.add(new Block(blockChain.get(blockChain.size()-1).hash, "Hey im the third Block"));
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
		if (isChainValid()) {
			System.out.println(blockchainJson);
		}else {
			JOptionPane.showMessageDialog(null, "something went wrong");
		}
		
	}
	
	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		for(int i =1;i<blockChain.size();i++) {
			currentBlock = blockChain.get(i);
			previousBlock = blockChain.get(i-1);
			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("current hash are not equal");
				return false;
			}
			
			if (!previousBlock.hash.equals(previousBlock.calculateHash())) {
				System.out.println("previous hash are not equal");
				return false;
			}
		}
		return true;
	}
	
}
