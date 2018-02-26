package noobchain;

import java.util.Date;

public class Block {

	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	private int nonce;
	
	public Block( String previousHash, String data) {
		super();
		 
		this.previousHash = previousHash;
		this.data = data;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculateHash = StringUtils.applySha256(
				previousHash+ Long.toString(timeStamp)+Integer.toString(nonce)+data);
		return calculateHash;
	}
	
	public void mineBlock(int difficulty) {
		
	}
	
}
