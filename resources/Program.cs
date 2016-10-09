using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;

namespace SanfeiClient
{
    class Program
    {
        static void Main(string[] args)
        {
            HttpWebRequest myHttpWebRequest = (HttpWebRequest)WebRequest.Create("http://localhost:8080/OAuth2Server/token");
            
            myHttpWebRequest.Method = "POST";
            myHttpWebRequest.ContentType = "application/x-www-form-urlencoded";
            

            string postData = "grant_type=password&username=sanfei&password=8888&client_id=2012";
            UTF8Encoding encoding = new UTF8Encoding();
            byte[] byte1 = encoding.GetBytes(postData);
            myHttpWebRequest.ContentLength = byte1.Length;

            Stream newStream = myHttpWebRequest.GetRequestStream();
            newStream.Write(byte1, 0, byte1.Length);

            
            HttpWebResponse myHttpWebResponse = (HttpWebResponse)myHttpWebRequest.GetResponse();

            Stream receiveStream = myHttpWebResponse.GetResponseStream();
            Encoding encode = System.Text.Encoding.GetEncoding("UTF-8");
            
            StreamReader readStream = new StreamReader(receiveStream, encode);
            Console.WriteLine("\r\nResponse stream received.");
            Char[] read = new Char[256];   
            int count = readStream.Read(read, 0, 256);
            Console.WriteLine("返回的JSON: \r\n");
            while (count > 0)
            {
                String str = new String(read, 0, count);
                Console.Write(str);
                count = readStream.Read(read, 0, 256);
            }
            Console.WriteLine("");
            myHttpWebResponse.Close();
            readStream.Close();
            Console.Read();
        }
    }
}
