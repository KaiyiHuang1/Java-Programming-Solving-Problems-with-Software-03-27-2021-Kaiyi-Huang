
/**
 * 在这里给出对类 BabyName1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyName1 {
    public void printNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100){
            System.out.println("Name " + rec.get(0) + 
                               "Gender" + rec.get(1) + 
                                "Num Born " + rec.get(2));
                            }
        }
    }
    
    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if(rec.get(1).equals("M")){
                totalBoys += numBorn;
            }else{
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
    }
    
    public int getRank(int year, String name, String gender){
        FileResource fr = new FileResource("C:\\Users\\54922\\OneDrive\\桌面\\Java Starter\\duke java\\Course 2\\week 4\\us_babynames_test\\yob"+year + "short.csv");
        int Fcount = 0;
        int count = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals("F")){
                Fcount ++;
            }
        }
        
        for(CSVRecord rec : fr.getCSVParser(false)){
            count++;
            if(rec.get(1).equals(gender) && rec.get(0).equals(name)&&rec.get(1).equals("F")){
                return count;
            }
            
            if(rec.get(1).equals(gender) && rec.get(0).equals(name)&&rec.get(1).equals("M")){
                return count-Fcount;
            }
        }
        return -1;
    }
    
    public int getRankFr(FileResource fr, String name, String gender){
        int Fcount = 0;
        int count = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals("F")){
                Fcount ++;
            }
        }
        
        for(CSVRecord rec : fr.getCSVParser(false)){
            count++;
            if(rec.get(1).equals(gender) && rec.get(0).equals(name)&&rec.get(1).equals("F")){
                return count;
            }
            
            if(rec.get(1).equals(gender) && rec.get(0).equals(name)&&rec.get(1).equals("M")){
                return count-Fcount;
            }
        }
        return -1;
    }
    
    public String getName(int year, int rank, String gender){
        FileResource fr = new FileResource("C:\\Users\\54922\\OneDrive\\桌面\\Java Starter\\duke java\\Course 2\\week 4\\us_babynames_test\\yob"+year + "short.csv");
        int Fcount = 0;
        int count = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals("F")){
                Fcount ++;
            }
        }
        
        for(CSVRecord rec : fr.getCSVParser(false)){
            count++;
            if(rec.get(1).equals(gender) && count == rank &&rec.get(1).equals("F")){
                return rec.get(0);
            }
            
            if(rec.get(1).equals(gender) && count - Fcount == rank &&rec.get(1).equals("M")){
                return rec.get(0);
            }
        }
        return "NO NAME";
    }
    
    public String whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        return newName;
        
    }
    
    public double yearOfHighestRank(String name,String gender){
        DirectoryResource dr = new DirectoryResource();
        double 
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            
        }
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public void testGet(){
        System.out.println(getRank(2012, "Mason", "M"));
        System.out.println(getName(2012, 10, "F"));
        System.out.println("Isabella born in 2012 would be "+ whatIsNameInYear("Isabella", 2012, 2014, "F") + " if she was born in 2014");
    }

}
