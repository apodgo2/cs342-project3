import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputFile {
	private String path = "";
	private String content = "";
	boolean isInvalid = false;

	public InputFile(String path) {
		this.path = path;
		parse();
	}
	
	public void read() {
		FileReader in = null;
	    
		try {
			in = new FileReader(path);
		       
		       int c;
		       while ((c = in.read()) != -1) {
		          content += c;
		       }
		    } catch (IOException e) {
		    	System.out.println("You have specified an inappropriate filepath!");
				e.printStackTrace();
				path = null;
				content = null;
			}finally {
		       if (in != null) {
		          try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       }
		    }
	}
	
	public void write() {
		FileWriter out = null;
	    
		try {
			out = new FileWriter(path);
		       
		    out.write(content);
		    } catch (IOException e) {
		    	System.out.println("You have specified an inappropriate filepath!");
				e.printStackTrace();
				path = null;
				content = null;
			}finally {
		       if (out != null) {
		          try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       }
		    }
	}
	
	public String getPath() {
		return path;
	}
	public String getContent() {
		return content;
	}
	protected void invalidate() {
		isInvalid = true;
	}
	public boolean isInvalid() {
		return isInvalid;
	}
	
	//override this:
	public void parse() {
		read();
	}
}
