package log2GPX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Log2GPX_launcher {
	
  public static void main(String[] args) throws IOException, NullPointerException {
	Log2GPX_launcher obj = new Log2GPX_launcher();
	obj.run();
  }

	@SuppressWarnings("resource")
	private void run() throws IOException, NullPointerException {

		File folder = new File("./data");
		String[] file = folder.list();
		int j = 0;
		
		PrintWriter fileWriterAnalysis = new PrintWriter(new File("./dataAnalysis/DiscoveryTime.csv"));
		fileWriterAnalysis.println("Technique;participant;time");
		fileWriterAnalysis.flush();
		
		PrintWriter fileWriterRegexBFResult = new PrintWriter(new File("./dataAnalysis/Regex_BF_Results.csv"));
		PrintWriter fileWriterRegexCYResult = new PrintWriter(new File("./dataAnalysis/Regex_CY_Results.csv"));

			// Main loop to treat each file of the previous folder
			for (int i = 0 ; i < file.length ; i++ ){
				// to determine all elements discovery time
				int u = 0 , v = 0 , w = 0 , x = 0 , y = 0 , z = 0;
				String a = "" , b = "" , c  = "" , d = "" , e  = "", f = "";
				boolean displayTime = false;
				// Condition to treat only csv
				if (file[i].contains("csv")){
					//Create .csv to analyse strat
					//Create GPX and fill head 
					PrintWriter fileWriter = new PrintWriter(new File( "./gpx/"
							+ file[i].subSequence(16, 35) + ".gpx"  ) );
					fileWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?> " + "\n" 
							+ " <gpx xmlns=\"http://www.topografix.com/GPX/1/1\" "
							+ "xmlns:gpxtpx=\"http://www.garmin.com/xmlschemas/TrackPointExtension/v1\" "
							+ "creator=\"M.S.\" version=\"1.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
							+ "xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd\"> \n" 
							+ "<metadata> \n"
							+"<time>2011-09-10T13:31:33Z</time>"
							+ "<bounds maxlat=\"49\" maxlon=\"-4\" minlat=\"48\" minlon=\"-5\"/>\n"
							+ "</metadata>");
					fileWriter.flush();			
					
					PrintWriter fileWriterRegex = new PrintWriter(new File("./dataAnalysis/REGEX_"
							+ file[i].subSequence(16, 35) + ".txt"));
					
					
					// Write waypoints lines using regex
					if (file[i].contains("OF1")) {
						String lineMap = "";
						BufferedReader brMap = new BufferedReader(new FileReader("./osm/OF1.osm"));
						brMap.readLine();brMap.readLine();
						for (int k = 0; k < 6; k++){							
							lineMap = brMap.readLine();
							Pattern p = Pattern.compile( "v='.*'" );
							Matcher m = p.matcher("" + lineMap);
							m.find();
							fileWriter.println( "<wpt lat = \""+ lineMap.subSequence(66, 75) 
								+" \" lon = \" " + lineMap.substring(82,92) + " \" " + " >" 
								+ "<name> " + lineMap.subSequence( m.start()+3 , m.end()-1) + "</name>"
								+ "</wpt>");
							fileWriter.flush();
							if (k==0) a = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==1) b = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==2) c = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==3) d = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==4) e = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==5) f = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
						}
					}
					if (file[i].contains("OF2")) {
						String lineMap = "";
						BufferedReader brMap = new BufferedReader(new FileReader("./osm/OF2.osm"));
						brMap.readLine();brMap.readLine();
						
						for (int k = 0; k < 6; k++){							
							lineMap = brMap.readLine();
							Pattern p = Pattern.compile( "v='.*'" );
							Matcher m = p.matcher("" + lineMap);
							m.find();
							fileWriter.println( 
									"<wpt lat = \""+ lineMap.subSequence(66, 75) 
								+" \" lon = \" " + lineMap.substring(82,92) + " \" " + " >" 
								+ "<name> " + lineMap.subSequence( m.start()+3 , m.end()-1) + "</name>"
								+ "</wpt>");
							fileWriter.flush();
							if (k==0) a = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==1) b = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==2) c = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==3) d = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==4) e = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==5) f = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
						}
					}
					if (file[i].contains("OF3")) {
						String lineMap = "";
						BufferedReader brMap = new BufferedReader(new FileReader("./osm/OF3.osm"));
						brMap.readLine();brMap.readLine();
						
						for (int k = 0; k < 6; k++){							
							lineMap = brMap.readLine();
							Pattern p = Pattern.compile( "v='.*'" );
							Matcher m = p.matcher("" + lineMap);
							m.find();
							fileWriter.println( 
									"<wpt lat = \""+ lineMap.subSequence(66, 75) 
								+" \" lon = \" " + lineMap.substring(82,92) + " \" " + " >" 
								+ "<name> " + lineMap.subSequence( m.start()+3 , m.end()-1) + "</name>"
								+ "</wpt>");
							fileWriter.flush();
							if (k==0) a = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==1) b = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==2) c = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==3) d = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==4) e = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==5) f = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
						}
					}
					if (file[i].contains("OF4")) {
						String lineMap = "";
						BufferedReader brMap = new BufferedReader(new FileReader("./osm/OF4.osm"));
						brMap.readLine();brMap.readLine();
						
						for (int k = 0; k < 6; k++){							
							lineMap = brMap.readLine();
							Pattern p = Pattern.compile( "v='.*'" );
							Matcher m = p.matcher("" + lineMap);
							m.find();
							fileWriter.println( 
									"<wpt lat = \""+ lineMap.subSequence(66, 75) 
								+" \" lon = \" " + lineMap.substring(82,92) + " \" " + " >" 
								+ "<name> " + lineMap.subSequence( m.start()+3 , m.end()-1) + "</name>"
								+ "</wpt>");
							fileWriter.flush();
							if (k==0) a = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==1) b = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==2) c = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==3) d = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==4) e = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							if (k==5) f = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
						}
					}
							
					// Write trackpoint head
					fileWriter.println( "<trk>" 
							+ "<name>" + file[i].subSequence(16, 35) 
							+ "</name>\n" 
							+ "<trkseg>");
					fileWriter.flush();
			
					// Read csv
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ";";
					br = new BufferedReader(new FileReader("./data/" + file[i]));
					line = br.readLine();		
					Long seconds = (long) 0;
					String lastTouch = "";
								
						// loop to read each line
						while ( (line = br.readLine()) != null ) {
							// Condition to verify line is filled
							if (line.length()>25){	
								String[] linepos = line.split(cvsSplitBy);
								seconds = (long)Double.parseDouble("" + linepos[0]);
								Date date = new Date(seconds*100000);
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
								SimpleDateFormat sdf2 = new SimpleDateFormat("H:m:s");
							
								// Condition to avoid strange points 
								if( Double.parseDouble(linepos[3]) > 48 
										&& Double.parseDouble(linepos[3]) < 49
										&& Double.parseDouble(linepos[4]) > -5
										&& Double.parseDouble(linepos[4]) < -4){
									fileWriter.println( "<trkpt lat=\"" + linepos[3]  + "\" lon=\"" + linepos[4] + "\">");
									fileWriter.flush();
									// add element touched and/or seconds to trackpoint
									if (linepos.length > 6){
										fileWriter.println("<name> " 
												+ "## " +  linepos[6] + " ##" 
												+ " -> " + Integer.parseInt(linepos[0])/1000 
												+ "s" +  " </name>");
										fileWriter.flush();
									}
									else{
										fileWriter.println("<name> " + Integer.parseInt(linepos[0])/1000 + "s" +" </name>");
										fileWriter.flush();
									}
									fileWriter.println("<time> " + sdf.format(date)  + "T" + sdf2.format(date) +"Z" +" </time>" + "\n"
											//+ "<ele> " + Integer.parseInt(linepos[0])/1000 + " </ele>"
											+ "</trkpt>");
									fileWriter.flush();
									// write out touched element
									if (linepos.length > 6){
										if (linepos[5].compareTo(lastTouch)!=0 
												&& linepos[5].compareTo("stopSpeak")!=0
												&& linepos[5].compareTo("list")!=0
												&& linepos[5].compareTo("")!=0){
											//System.out.println(linepos[6] + "\t" + Integer.parseInt(linepos[0])/1000);
											// transform
											if ((file[i].subSequence(34, 35).toString().contains("1"))){
												if (linepos[6].substring(0, 1).equals("t"))fileWriterRegex.print("A");
												if (linepos[6].substring(0, 1).equals("d"))fileWriterRegex.print("B");
												if (linepos[6].substring(0, 1).equals("l"))fileWriterRegex.print("C");
												if (linepos[6].substring(0, 1).equals("o"))fileWriterRegex.print("D");
												if (linepos[6].substring(0, 1).equals("b"))fileWriterRegex.print("E");
												if (linepos[6].substring(0, 1).equals("v"))fileWriterRegex.print("F");
												fileWriterRegex.flush();
											}
											if ((file[i].subSequence(34, 35).toString().contains("2"))){
												if (linepos[6].substring(0, 1).equals("f"))fileWriterRegex.print("A");
												if (linepos[6].substring(0, 1).equals("m"))fileWriterRegex.print("B");
												if (linepos[6].substring(0, 1).equals("l"))fileWriterRegex.print("C");
												if (linepos[6].substring(0, 1).equals("p"))fileWriterRegex.print("D");
												if (linepos[6].substring(0, 1).equals("c"))fileWriterRegex.print("E");
												if (linepos[6].substring(0, 1).equals("t"))fileWriterRegex.print("F");
												fileWriterRegex.flush();
											}
											if ((file[i].subSequence(34, 35).toString().contains("3"))){
												if (linepos[6].substring(0, 1).equals("f"))fileWriterRegex.print("A");
												if (linepos[6].substring(0, 1).equals("s"))fileWriterRegex.print("B");
												if (linepos[6].substring(0, 1).equals("c"))fileWriterRegex.print("C");
												if (linepos[6].substring(0, 1).equals("e"))fileWriterRegex.print("D");
												if (linepos[6].substring(0, 1).equals("b"))fileWriterRegex.print("E");
												if (linepos[6].substring(0, 1).equals("j"))fileWriterRegex.print("F");
												fileWriterRegex.flush();
											}						
											if ((file[i].subSequence(34, 35).toString().contains("4"))){
												if (linepos[6].substring(2, 3).equals("i"))fileWriterRegex.print("A");
												if (linepos[6].substring(2, 3).equals("l"))fileWriterRegex.print("B");
												if (linepos[6].substring(2, 3).equals("g"))fileWriterRegex.print("C");
												if (linepos[6].substring(2, 3).equals("r"))fileWriterRegex.print("D");
												if (linepos[6].substring(2, 3).equals("t"))fileWriterRegex.print("E");
												if (linepos[6].substring(2, 3).equals("a"))fileWriterRegex.print("F");
												fileWriterRegex.flush();
											}
											
											lastTouch = linepos[5];
												if (u==0 && linepos[5].contains(a)) {
													u=1;
													//System.out.println("u -> " + linepos[5] + " = " + u + " à " + linepos[0] );
												}
												if (v==0 && linepos[5].contains(b)) {
													v=1;
													//System.out.println("v -> " + linepos[5] + " = " + v + " à " + linepos[0] );
												}
												if (w==0 && linepos[5].equals(c)){
													w=1;
													//System.out.println("w -> " + linepos[5] + " = " + w + " à " + linepos[0] );
												}
												if (x==0 && linepos[5].equals(d)){
													x=1;
													//System.out.println("x -> " + linepos[5] + " = " + x + " à " + linepos[0] );
												}
												if (y==0 && linepos[5].equals(e)){
													y=1;
													//System.out.println("y -> " + linepos[5] + " = " + y + " à " + linepos[0] );
												}
												if (z==0 && linepos[5].equals(f)){
													z=1;
													//System.out.println("z -> " + linepos[5] + " = " + z + " à " + linepos[0] );
												}
												if ( (u+v+w+x+y+z) == 6 && !displayTime){
													fileWriterAnalysis.println(file[i].subSequence(16, 19)
															+ ";" 
															+ file[i].subSequence(20, 23)
															+ ";"
															+ Integer.parseInt(linepos[0])/1000 +"");
													fileWriterAnalysis.flush();													
													//System.out.println(file[i].subSequence(16, 35)
															//+ " -> TIME TO DISCOVERY = " 
															//+ Integer.parseInt(linepos[0])/1000 + "s");
													displayTime = true;
												}
												                                         
										}
									}
								} // end of if to write consistent point
							} // end of if to verify line
						} //end of while
						
						// Write the end of the GPX file
						fileWriter.println("</trkseg>" + "\n"
						+ "</trk>" + "\n" 
						+ "</gpx>");
						fileWriter.flush();
						fileWriter.close();
						
						
						
						//Count strategies
						BufferedReader bfReg = new BufferedReader(new FileReader("./dataAnalysis/REGEX_"
								+ file[i].subSequence(16, 35) + ".txt"));
							String lineReg = bfReg.readLine();	
							
							int countBaF = 0;						
							String[] allBaF = {	"ABA" , "ACA" , "ADA" , "AEA" , "AFA" ,
												"BAB" , "BCB" , "BDB" , "BEB" , "BFB" ,
												"CAC" , "CBC" , "CDC" , "CEC" , "CFC" , 
												"DAD" , "DBD" , "DCD" , "DED" , "DFD" ,
												"EAE" , "EBE" , "ECE" , "EDE" , "EFE" , 
												"FAF" , "FBF" , "FCF" , "FDF" , "FEF"
							} ;
							
							//Count BAF
							for(int iReg = 0 ; iReg < allBaF.length ; iReg++){
								Pattern p = Pattern.compile( "" + allBaF[iReg] ); 
								Matcher m = p.matcher("" + lineReg);
								while (m.find()){
									countBaF++;
									//System.out.println(allBaF[iReg] + " => FOUND");
								}
							}
							System.out.println("Back-and-Forth => #### " + countBaF +" ####  FOUND");
							fileWriterRegexBFResult.print(file[i].subSequence(16,19)+ ";" + countBaF + "\n");
							fileWriterRegexBFResult.flush();
	
							//Count cyclic
							int countCyc = 0;	
							String[] allCyclic = {"ABCDEF", "ABCDFE", "ABCEDF", "ABCEFD", "ABCFDE", "ABCFED", "ABDCEF", "ABDCFE", "ABDECF", "ABDEFC", "ABDFCE", "ABDFEC", "ABECDF", "ABECFD", "ABEDCF", "ABEDFC", "ABEFCD", "ABEFDC", "ABFCDE", "ABFCED", "ABFDCE", "ABFDEC", "ABFECD", "ABFEDC", "ACBDEF", "ACBDFE", "ACBEDF", "ACBEFD", "ACBFDE", "ACBFED", "ACDBEF", "ACDBFE", "ACDEBF", "ACDEFB", "ACDFBE", "ACDFEB", "ACEBDF", "ACEBFD", "ACEDBF", "ACEDFB", "ACEFBD", "ACEFDB", "ACFBDE", "ACFBED", "ACFDBE", "ACFDEB", "ACFEBD", "ACFEDB", "ADBCEF", "ADBCFE", "ADBECF", "ADBEFC", "ADBFCE", "ADBFEC", "ADCBEF", "ADCBFE", "ADCEBF", "ADCEFB", "ADCFBE", "ADCFEB", "ADEBCF", "ADEBFC", "ADECBF", "ADECFB", "ADEFBC", "ADEFCB", "ADFBCE", "ADFBEC", "ADFCBE", "ADFCEB", "ADFEBC", "ADFECB", "AEBCDF", "AEBCFD", "AEBDCF", "AEBDFC", "AEBFCD", "AEBFDC", "AECBDF", "AECBFD", "AECDBF", "AECDFB", "AECFBD", "AECFDB", "AEDBCF", "AEDBFC", "AEDCBF", "AEDCFB", "AEDFBC", "AEDFCB", "AEFBCD", "AEFBDC", "AEFCBD", "AEFCDB", "AEFDBC", "AEFDCB", "AFBCDE", "AFBCED", "AFBDCE", "AFBDEC", "AFBECD", "AFBEDC", "AFCBDE", "AFCBED", "AFCDBE", "AFCDEB", "AFCEBD", "AFCEDB", "AFDBCE", "AFDBEC", "AFDCBE", "AFDCEB", "AFDEBC", "AFDECB", "AFEBCD", "AFEBDC", "AFECBD", "AFECDB", "AFEDBC", "AFEDCB", "BACDEF", "BACDFE", "BACEDF", "BACEFD", "BACFDE", "BACFED", "BADCEF", "BADCFE", "BADECF", "BADEFC", "BADFCE", "BADFEC", "BAECDF", "BAECFD", "BAEDCF", "BAEDFC", "BAEFCD", "BAEFDC", "BAFCDE", "BAFCED", "BAFDCE", "BAFDEC", "BAFECD", "BAFEDC", "BCADEF", "BCADFE", "BCAEDF", "BCAEFD", "BCAFDE", "BCAFED", "BCDAEF", "BCDAFE", "BCDEAF", "BCDEFA", "BCDFAE", "BCDFEA", "BCEADF", "BCEAFD", "BCEDAF", "BCEDFA", "BCEFAD", "BCEFDA", "BCFADE", "BCFAED", "BCFDAE", "BCFDEA", "BCFEAD", "BCFEDA", "BDACEF", "BDACFE", "BDAECF", "BDAEFC", "BDAFCE", "BDAFEC", "BDCAEF", "BDCAFE", "BDCEAF", "BDCEFA", "BDCFAE", "BDCFEA", "BDEACF", "BDEAFC", "BDECAF", "BDECFA", "BDEFAC", "BDEFCA", "BDFACE", "BDFAEC", "BDFCAE", "BDFCEA", "BDFEAC", "BDFECA", "BEACDF", "BEACFD", "BEADCF", "BEADFC", "BEAFCD", "BEAFDC", "BECADF", "BECAFD", "BECDAF", "BECDFA", "BECFAD", "BECFDA", "BEDACF", "BEDAFC", "BEDCAF", "BEDCFA", "BEDFAC", "BEDFCA", "BEFACD", "BEFADC", "BEFCAD", "BEFCDA", "BEFDAC", "BEFDCA", "BFACDE", "BFACED", "BFADCE", "BFADEC", "BFAECD", "BFAEDC", "BFCADE", "BFCAED", "BFCDAE", "BFCDEA", "BFCEAD", "BFCEDA", "BFDACE", "BFDAEC", "BFDCAE", "BFDCEA", "BFDEAC", "BFDECA", "BFEACD", "BFEADC", "BFECAD", "BFECDA", "BFEDAC", "BFEDCA", "CABDEF", "CABDFE", "CABEDF", "CABEFD", "CABFDE", "CABFED", "CADBEF", "CADBFE", "CADEBF", "CADEFB", "CADFBE", "CADFEB", "CAEBDF", "CAEBFD", "CAEDBF", "CAEDFB", "CAEFBD", "CAEFDB", "CAFBDE", "CAFBED", "CAFDBE", "CAFDEB", "CAFEBD", "CAFEDB", "CBADEF", "CBADFE", "CBAEDF", "CBAEFD", "CBAFDE", "CBAFED", "CBDAEF", "CBDAFE", "CBDEAF", "CBDEFA", "CBDFAE", "CBDFEA", "CBEADF", "CBEAFD", "CBEDAF", "CBEDFA", "CBEFAD", "CBEFDA", "CBFADE", "CBFAED", "CBFDAE", "CBFDEA", "CBFEAD", "CBFEDA", "CDABEF", "CDABFE", "CDAEBF", "CDAEFB", "CDAFBE", "CDAFEB", "CDBAEF", "CDBAFE", "CDBEAF", "CDBEFA", "CDBFAE", "CDBFEA", "CDEABF", "CDEAFB", "CDEBAF", "CDEBFA", "CDEFAB", "CDEFBA", "CDFABE", "CDFAEB", "CDFBAE", "CDFBEA", "CDFEAB", "CDFEBA", "CEABDF", "CEABFD", "CEADBF", "CEADFB", "CEAFBD", "CEAFDB", "CEBADF", "CEBAFD", "CEBDAF", "CEBDFA", "CEBFAD", "CEBFDA", "CEDABF", "CEDAFB", "CEDBAF", "CEDBFA", "CEDFAB", "CEDFBA", "CEFABD", "CEFADB", "CEFBAD", "CEFBDA", "CEFDAB", "CEFDBA", "CFABDE", "CFABED", "CFADBE", "CFADEB", "CFAEBD", "CFAEDB", "CFBADE", "CFBAED", "CFBDAE", "CFBDEA", "CFBEAD", "CFBEDA", "CFDABE", "CFDAEB", "CFDBAE", "CFDBEA", "CFDEAB", "CFDEBA", "CFEABD", "CFEADB", "CFEBAD", "CFEBDA", "CFEDAB", "CFEDBA", "DABCEF", "DABCFE", "DABECF", "DABEFC", "DABFCE", "DABFEC", "DACBEF", "DACBFE", "DACEBF", "DACEFB", "DACFBE", "DACFEB", "DAEBCF", "DAEBFC", "DAECBF", "DAECFB", "DAEFBC", "DAEFCB", "DAFBCE", "DAFBEC", "DAFCBE", "DAFCEB", "DAFEBC", "DAFECB", "DBACEF", "DBACFE", "DBAECF", "DBAEFC", "DBAFCE", "DBAFEC", "DBCAEF", "DBCAFE", "DBCEAF", "DBCEFA", "DBCFAE", "DBCFEA", "DBEACF", "DBEAFC", "DBECAF", "DBECFA", "DBEFAC", "DBEFCA", "DBFACE", "DBFAEC", "DBFCAE", "DBFCEA", "DBFEAC", "DBFECA", "DCABEF", "DCABFE", "DCAEBF", "DCAEFB", "DCAFBE", "DCAFEB", "DCBAEF", "DCBAFE", "DCBEAF", "DCBEFA", "DCBFAE", "DCBFEA", "DCEABF", "DCEAFB", "DCEBAF", "DCEBFA", "DCEFAB", "DCEFBA", "DCFABE", "DCFAEB", "DCFBAE", "DCFBEA", "DCFEAB", "DCFEBA", "DEABCF", "DEABFC", "DEACBF", "DEACFB", "DEAFBC", "DEAFCB", "DEBACF", "DEBAFC", "DEBCAF", "DEBCFA", "DEBFAC", "DEBFCA", "DECABF", "DECAFB", "DECBAF", "DECBFA", "DECFAB", "DECFBA", "DEFABC", "DEFACB", "DEFBAC", "DEFBCA", "DEFCAB", "DEFCBA", "DFABCE", "DFABEC", "DFACBE", "DFACEB", "DFAEBC", "DFAECB", "DFBACE", "DFBAEC", "DFBCAE", "DFBCEA", "DFBEAC", "DFBECA", "DFCABE", "DFCAEB", "DFCBAE", "DFCBEA", "DFCEAB", "DFCEBA", "DFEABC", "DFEACB", "DFEBAC", "DFEBCA", "DFECAB", "DFECBA", "EABCDF", "EABCFD", "EABDCF", "EABDFC", "EABFCD", "EABFDC", "EACBDF", "EACBFD", "EACDBF", "EACDFB", "EACFBD", "EACFDB", "EADBCF", "EADBFC", "EADCBF", "EADCFB", "EADFBC", "EADFCB", "EAFBCD", "EAFBDC", "EAFCBD", "EAFCDB", "EAFDBC", "EAFDCB", "EBACDF", "EBACFD", "EBADCF", "EBADFC", "EBAFCD", "EBAFDC", "EBCADF", "EBCAFD", "EBCDAF", "EBCDFA", "EBCFAD", "EBCFDA", "EBDACF", "EBDAFC", "EBDCAF", "EBDCFA", "EBDFAC", "EBDFCA", "EBFACD", "EBFADC", "EBFCAD", "EBFCDA", "EBFDAC", "EBFDCA", "ECABDF", "ECABFD", "ECADBF", "ECADFB", "ECAFBD", "ECAFDB", "ECBADF", "ECBAFD", "ECBDAF", "ECBDFA", "ECBFAD", "ECBFDA", "ECDABF", "ECDAFB", "ECDBAF", "ECDBFA", "ECDFAB", "ECDFBA", "ECFABD", "ECFADB", "ECFBAD", "ECFBDA", "ECFDAB", "ECFDBA", "EDABCF", "EDABFC", "EDACBF", "EDACFB", "EDAFBC", "EDAFCB", "EDBACF", "EDBAFC", "EDBCAF", "EDBCFA", "EDBFAC", "EDBFCA", "EDCABF", "EDCAFB", "EDCBAF", "EDCBFA", "EDCFAB", "EDCFBA", "EDFABC", "EDFACB", "EDFBAC", "EDFBCA", "EDFCAB", "EDFCBA", "EFABCD", "EFABDC", "EFACBD", "EFACDB", "EFADBC", "EFADCB", "EFBACD", "EFBADC", "EFBCAD", "EFBCDA", "EFBDAC", "EFBDCA", "EFCABD", "EFCADB", "EFCBAD", "EFCBDA", "EFCDAB", "EFCDBA", "EFDABC", "EFDACB", "EFDBAC", "EFDBCA", "EFDCAB", "EFDCBA", "FABCDE", "FABCED", "FABDCE", "FABDEC", "FABECD", "FABEDC", "FACBDE", "FACBED", "FACDBE", "FACDEB", "FACEBD", "FACEDB", "FADBCE", "FADBEC", "FADCBE", "FADCEB", "FADEBC", "FADECB", "FAEBCD", "FAEBDC", "FAECBD", "FAECDB", "FAEDBC", "FAEDCB", "FBACDE", "FBACED", "FBADCE", "FBADEC", "FBAECD", "FBAEDC", "FBCADE", "FBCAED", "FBCDAE", "FBCDEA", "FBCEAD", "FBCEDA", "FBDACE", "FBDAEC", "FBDCAE", "FBDCEA", "FBDEAC", "FBDECA", "FBEACD", "FBEADC", "FBECAD", "FBECDA", "FBEDAC", "FBEDCA", "FCABDE", "FCABED", "FCADBE", "FCADEB", "FCAEBD", "FCAEDB", "FCBADE", "FCBAED", "FCBDAE", "FCBDEA", "FCBEAD", "FCBEDA", "FCDABE", "FCDAEB", "FCDBAE", "FCDBEA", "FCDEAB", "FCDEBA", "FCEABD", "FCEADB", "FCEBAD", "FCEBDA", "FCEDAB", "FCEDBA", "FDABCE", "FDABEC", "FDACBE", "FDACEB", "FDAEBC", "FDAECB", "FDBACE", "FDBAEC", "FDBCAE", "FDBCEA", "FDBEAC", "FDBECA", "FDCABE", "FDCAEB", "FDCBAE", "FDCBEA", "FDCEAB", "FDCEBA", "FDEABC", "FDEACB", "FDEBAC", "FDEBCA", "FDECAB", "FDECBA", "FEABCD", "FEABDC", "FEACBD", "FEACDB", "FEADBC", "FEADCB", "FEBACD", "FEBADC", "FEBCAD", "FEBCDA", "FEBDAC", "FEBDCA", "FECABD", "FECADB", "FECBAD", "FECBDA", "FECDAB", "FECDBA", "FEDABC", "FEDACB", "FEDBAC", "FEDBCA", "FEDCAB", "FEDCBA"};
							
							for(int iReg = 0 ; iReg < allCyclic.length ; iReg++){
								Pattern p = Pattern.compile( "" + allCyclic[iReg] ); 
								Matcher m = p.matcher("" + lineReg);
								while (m.find()){
									countCyc++;
									//System.out.println(allCyclic[iReg] + " => FOUND");
								}
							}
							System.out.println("Cyclic => #### " + countCyc +" ####  FOUND");
							fileWriterRegexCYResult.print(file[i].subSequence(16,19)+ ";" + countCyc + "\n");
							fileWriterRegexCYResult.flush();
							
							 
/*		// TENTATIVE D'ARRANGEMENT					
	
							char[] cyclicArrangement = {9,9,9,9,9,9};
							for (int ia=0;ia<6;ia++){
								cyclicArrangement[ia]='A';
								for (int ib=0;ib<6;ib++){
									if (ia != ib) cyclicArrangement[ib]='B';
									for (int ic=0;ic<6;ic++){
										if ( (ic != ia) 
										  && (ic != ib)  ) cyclicArrangement[ic]='C';
										for (int id=0;id<6;id++){
											if ( (id != ia) 
											  && (id != ib)
										      && (id != ic)  ) cyclicArrangement[id]='D';
											for (int ie=0;ie<6;ie++){
												if ( (ie != ia) 
												  && (ie != ib)
												  && (ie != ic)
											      && (ie != id)  ) cyclicArrangement[ie]='E';
													for (int iF=0;iF<6;iF++){
														if ( (iF != ia) 
														  && (iF != ib)
														  && (iF != ic)
														  && (iF != id)
													      && (iF != ie)  ) {
															cyclicArrangement[iF]='F';
															System.out.println(""	+ cyclicArrangement[0] 
																					+ cyclicArrangement[1]
																					+ cyclicArrangement[2] 
																					+ cyclicArrangement[3]
																					+ cyclicArrangement[4] 
																					+ cyclicArrangement[5]);
														}//end of final if
													}//end of iF 
												}//end of iE
											}//end of iD
										}//end of iC
									} //end of iB
								}// end of iA
							*/
//
//							int countCen = 0;							
//							String[] allCen = {	"ABACA" , "BCDEFAB" , "CDEFABC" , "DEFABCD" , "EFABCDE" , "FABCDEF" , 
//												"BAB" , "BCB" , "BDB" , "BEB" , "BFB" ,
//												"CAC" , "CBC" , "CDC" , "CEC" , "CFC" , 
//												"DAD" , "DBD" , "DCD" , "DED" , "DFD" ,
//												"EAE" , "EBE" , "ECE" , "EDE" , "EFE" , 
//												"FAF" , "FBF" , "FCF" , "FDF" , "FEF"
//							} ;
//							
//							for(int iReg = 0 ; iReg < allBaF.length ; iReg++){
//								Pattern p = Pattern.compile( "" + allBaF[iReg] ); 
//								Matcher m = p.matcher("" + lineReg);
//								while (m.find()){
//									countBaF++;
//									//System.out.println(allBaF[iReg] + " => FOUND");
//								}
//							}
//							System.out.println("Back-and-Forth => #### " + countBaF +" ####  FOUND");
//							fileWriterRegexResult.print("" + countBaF + ";");
//							fileWriterRegexResult.flush();

//							int countCyc = 0;
//							String[] allCyc = {	"ABCDEFA" , "BCDEFAB" , "CDEFABC" , "DEFABCD" , "EFABCDE" , "FABCDEF" , 
//												"BAB" , "BCB" , "BDB" , "BEB" , "BFB" ,
//												"CAC" , "CBC" , "CDC" , "CEC" , "CFC" , 
//												"DAD" , "DBD" , "DCD" , "DED" , "DFD" ,
//												"EAE" , "EBE" , "ECE" , "EDE" , "EFE" , 
//												"FAF" , "FBF" , "FCF" , "FDF" , "FEF"
//							} ;
//							
//							for(int iReg = 0 ; iReg < allBaF.length ; iReg++){
//								Pattern p = Pattern.compile( "" + allBaF[iReg] ); 
//								Matcher m = p.matcher("" + lineReg);
//								while (m.find()){
//									countBaF++;
//									//System.out.println(allBaF[iReg] + " => FOUND");
//								}
//							}
//							System.out.println("Back-and-Forth => #### " + countBaF +" ####  FOUND");
//							fileWriterRegexResult.print("" + countBaF + ";");
//							fileWriterRegexResult.flush();
							
				
					j++;	
					System.out.println(" File " + (j) + " : " + file[i].subSequence(16, 35)+ " -> done");
					System.out.println("");
					} // end of if contains csv
				
				} //end of for
			
			//Write the end of DiscoveryFile
			fileWriterAnalysis.println("DIG;P11;126");
			fileWriterAnalysis.flush();
			fileWriterAnalysis.println("DIG;P04;119");
			fileWriterAnalysis.flush();
			fileWriterAnalysis.println("EDP;P03;314 ");
			fileWriterAnalysis.flush();
			fileWriterAnalysis.close();
			
			} //end of run
	
		} //end of main
		

	  