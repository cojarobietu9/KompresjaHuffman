package pl.edu.pw.ee.aisd2024ex5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.util.ArrayList;

public class HuffCodeFile {

    private File outFile;
    private RandomAccessFile raf;
    private int counter;
    private char bin;
    private byte outbin;

    public HuffCodeFile(String outFileName) throws IOException {
        this.outFile = new File(outFileName);
        this.raf = new RandomAccessFile(this.outFile, "rw");
        this.raf.setLength(0);
        this.counter = 0;
        this.bin = 0;
        this.outbin = 0;
    }

    public void textToHuffCodeFile(ArrayList<Character> symbols, ArrayList<String> codes, File inFile) throws IOException {
        int size = symbols.size();
        this.raf.write(0);
        try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
            int ch;
            while ((ch = br.read()) != -1) {
                for (int i = 0; i < size; i++) {
                    if (symbols.get(i) == (char) ch) {
                        writeBin(codes.get(i));
                    }
                }
            }


            if (this.counter > 0) {
                this.bin <<= (8 - this.counter);
                int tmpCounter = this.counter;
                this.counter = 8;
                this.writeToFile();
                this.raf.seek(0);
                this.raf.write(tmpCounter);
            }

            this.raf.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    private void writeBin(String code) throws IOException {
        if (this.counter + code.length() > 16) {
            int len = 16 - this.counter;
            for (int i = 0; i < code.length(); i++) {
                this.bin <<= 1;
                this.counter++;
                if (code.charAt(i) == '1') {
                    this.bin += 1; // Ustaw najmniej znaczący bit na 1
                }

                // Jeśli akumulator jest pełny (8 bitów), zapisz bajt
                if (this.counter >= 8) {
                    this.writeToFile();
                }
            }
        } else {
            for (int i = 0; i < code.length(); i++) {
                this.bin <<= 1;
                this.counter++;
                if (code.charAt(i) == '1') {
                    this.bin += 1;
                }
            }
            if (this.counter >= 8)
                this.writeToFile();
        }
    }

    private void writeToFile() throws IOException {
        char tmp = this.bin;
        this.outbin = (byte) (this.bin >> (this.counter - 8));
        this.raf.write(this.outbin);
        this.counter -= 8;
        this.bin = tmp;
    }
}


/*package pl.edu.pw.ee.aisd2024ex5;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class HuffCodeFile {

    private File outFile;
    private BufferedWriter bw;
    private int counter;
    private char bin;
    private byte outbin;
    public HuffCodeFile(String outFileName) throws IOException {
        this.outFile = new File(outFileName);
        this.outFile.createNewFile();
        this.bw = new BufferedWriter(new FileWriter(this.outFile));
        this.counter = 0;
        this.bin = 0;
        this.outbin = 0;
    }

    public void textToHuffCodeFile(ArrayList<Character> symbols, ArrayList<String> codes,File inFile) throws IOException {
        int size = symbols.size();
        try{
            BufferedReader br = new BufferedReader(new FileReader(inFile));
            int ch;
            while ((ch = br.read()) != -1) {
                for(int i=0;i<size;i++){
                    if (symbols.get(i)==(char) ch){
                        writeBin(codes.get(i));
                    }
                }
            }

            if(this.counter > 0){
                this.bin <<=(8-this.counter);
                this.counter = 8;
                this.writeToFile();
            }

            this.bw.close();
        }
        catch(IOException e){
            throw new IOException(e);
        }
    }

    private void writeBin(String code) throws IOException{
        if(this.counter+code.length()>16){
            int len = 16-this.counter;
            for(int i=0; i<len; i++){
                this.bin<<=1;
                this.counter++;
                if(code.charAt(i)=='1'){
                    this.bin+=1;
                }
            }

            this.writeToFile();
            for(int i=len; i<code.length(); i++){
                    this.bin<<=1;
                    this.counter++;
                    if(code.charAt(i)=='1'){
                        this.bin+=1;
                    }
            }
            if( this.counter >= 8)
                this.writeToFile();
        }
        else{
            for(int i=0; i<code.length(); i++){
                this.bin<<=1;
                this.counter++;
                if(code.charAt(i)=='1'){
                    this.bin+=1;
                }
            }
            if (this.counter >= 8)
                this.writeToFile();
        }
    }

    private void writeToFile() throws IOException{
        char tmp = this.bin;
        this.outbin = (byte) ((byte) this.bin >> (this.counter - 8));
        this.bw.write(this.outbin);
        this.counter -= 8;
        this.bin = tmp;
    }
}
*/