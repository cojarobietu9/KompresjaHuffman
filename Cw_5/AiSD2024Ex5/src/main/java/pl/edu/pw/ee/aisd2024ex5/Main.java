package pl.edu.pw.ee.aisd2024ex5;
import java.io.File;
import java.io.IOException;

public class Main {
        public static void main(String[] args) throws IOException {
                String s ="\0";
                String inFileName = new String();
                String outFileName = new String();
                for(String a : args){
                        if(s.equals("--in")){
                                inFileName = a;
                        }
                        if(s.equals("--out")){
                                outFileName = a;
                        }
                        s = a;
                }

                if(!checkFileArgs(inFileName, 'i') || !checkFileArgs(outFileName, 'o')){
                        throw new IOException("Incorrect arguments! Please give the proper names of in-file and out-file");
                }

                File file = new File(inFileName);
                NodesList n = new NodesList(file);
                HuffTree ht =  new HuffTree(n.getNodes());
                GenerateHuffCode hc = new GenerateHuffCode(ht);
                HuffCodeFile hf = new HuffCodeFile(outFileName);
                hf.textToHuffCodeFile(hc.getSymbols(), hc.getCodes(), file);


        }

        private static boolean checkFileArgs(String filename, char typ) {
                if(filename.isEmpty() || filename.isBlank())
                        return false;
                if(typ == 'i') {
                        File file = new File(filename);
                        if(!file.isFile() || !file.exists())
                                return false;
                }
                return true;
        }
}
