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
		
		///media/mathieu/26E07A43E07A196F/Documents and Settings/Mathieu/Dropbox/4TI_shared/Materiels/VisualisationConfiguration/OF1.png
		// object to browse folder
		File folder = new File("./data");
		//File folder = new File("/media/mathieu/26E07A43E07A196F/Documents and Settings/Mathieu/Dropbox/4TI_local/explorationStrat/data");
		String[] file = folder.list();
		int j = 0;
			// Main loop to treat each file of the previous folder
			for (int i = 0 ; i < file.length ; i++ ){
				// to determine all elements discovery time
				int u = 0 , v = 0 , w = 0 , x = 0 , y = 0 , z = 0;
				String a = "" , b = "" , c  = "" , d = "" , e  = "", f = "";
				boolean displayTime = false;
				// Condition to treat only csv
				if (file[i].contains("csv")){
					//Create .csv to analyse strat
					/*PrintWriter fileWriterAnalysis = new PrintWriter(new File( "/home/mathieu/Dropbox/4TI_local/explorationStrat/autoAnalysis/" 
							+ file[i].subSequence(16, 35) + "_AUTO.csv"  ) );*/
					// Create GPX and fill head
					//PrintWriter fileWriter = new PrintWriter(new File( "/home/mathieu/Dropbox/4TI_local/explorationStrat/gpx/" 
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
							a = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							b = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							c = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							d = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							e = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							f = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
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
							a = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							b = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							c = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							d = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							e = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							f = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
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
							a = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							b = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							c = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							d = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							e = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							f = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
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
							a = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							b = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							c = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							d = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							e = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
							f = (String)lineMap.subSequence( m.start()+3 , m.end()-1);
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
									// write out elements touch
									if (linepos.length > 6){
										if (linepos[6].compareTo(lastTouch)!=0 && linepos[6].compareTo("stopSpeak")!=0 && linepos[6].compareTo("")!=0){
											//System.out.println(linepos[6] + "\t" + Integer.parseInt(linepos[0])/1000);
											lastTouch = linepos[6];
												if (u==0 && linepos[6].equals(a)) u=1;
												if (v==0 && linepos[6].equals(b)) v=1;
												if (w==0 && linepos[6].equals(c)) w=1;
												if (x==0 && linepos[6].equals(d)) x=1;
												if (y==0 && linepos[6].equals(e)) y=1;
												if (z==0 && linepos[6].equals(f)) z=1;
												if ( (u+v+w+x+y+z) == 6 && !displayTime){
													System.out.println("TIME TO DISCOVERY = " 
															+ Integer.parseInt(linepos[0])/1000 + "s");
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
						
					j++;	
					System.out.println(" File " + (j) + " : " + file[i].subSequence(16, 35)+ " -> done");	
					} // end of if contains csv
				
				} //end of for
			
			} //end of run
	
		} //end of main
		

	  