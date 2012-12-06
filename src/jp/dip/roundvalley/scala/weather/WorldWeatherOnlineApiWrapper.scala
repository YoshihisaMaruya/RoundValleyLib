package jp.dip.roundvalley.scala.weather


/* ìVãCèÓïÒéÊìæ
 * http://www.worldweatheronline.com/feed-generater.aspx
 * 
 */
import scala.io.Source
import scala.xml.XML
import scala.xml.parsing.{ConstructingParser,XhtmlParser}
import scala.xml.NodeSeq


object WorldWeatherOnlineApiWrapper {
	
    def getCurrentWeatherFromLatLon(key: String,lat:String,log:String,day:String):String = {
        //ex. http://free.worldweatheronline.com/feed/weather.ashx?q=0.00,0.00&format=xml&num_of_days=2&key=???
    	val url = "http://free.worldweatheronline.com/feed/weather.ashx?q="+lat+","+log+"&format=xml&num_of_days="+day+"&key="+key
    	val source = Source.fromURL(url)
    	val xml = XML.loadString( source.getLines.mkString )
    	val weatherDesc = xml \\ "weatherDesc"
    	weatherDesc.toList.head.text
	}
    
    def main(args:Array[String]):Unit = {
      println(getCurrentWeatherFromLatLon("24c7ab0480154422120512", "35.9470147", "139.6246016","2"))
    }
}