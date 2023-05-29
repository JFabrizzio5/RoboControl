char estado= 0;
int EnB= 9;
int in4= 8;
int in3= 7;
int in1 = 12;  // Pin que controla el sentido de giro Motor A
int in2 = 13;  // Pin que controla el sentido de giro Motor A
 // Pin que controla la velocidad del  Motor A
void setup ()
{
    Serial.begin(9600);
  pinMode(in1, OUTPUT);    // Configura  los pines como salida
  pinMode(in2, OUTPUT);
  pinMode(in3, OUTPUT);
  pinMode(in4, OUTPUT);    // Configura  los pines como salida

}
void loop()
{


    if(Serial.available()){        // lee el bluetooth y almacena en estado
      estado = Serial.read();
  }

if(estado=='w'){      
  digitalWrite(in1, HIGH);  
  digitalWrite(in4, HIGH);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);     //Girar AdE

}


if(estado=='x'){      
  digitalWrite(in1, LOW);  
  digitalWrite(in4, LOW);
  digitalWrite(in2, HIGH);
  digitalWrite(in3, HIGH);    //Girar ATR

 
 }

if(estado=='c'){      
  digitalWrite(in1, LOW);  
  digitalWrite(in4, LOW);
  digitalWrite(in2, LOW);
  digitalWrite(in3, HIGH);    //Girar ATR derecha

 
 }
if(estado=='z'){      
  digitalWrite(in1, LOW);  
  digitalWrite(in4, LOW);
  digitalWrite(in2, HIGH);
  digitalWrite(in3, LOW);    //Girar ATR izquierda

 
 }
if(estado=='q'){      
  digitalWrite(in1, HIGH);  
  digitalWrite(in4, LOW);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);    //Girar ATR izquierda

 
 }
 if(estado=='e'){      
  digitalWrite(in1, LOW);  
  digitalWrite(in4, HIGH);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);    //Girar ATR izquierda

 
 }
 if(estado=='s'){      
  digitalWrite(in1, LOW);  
  digitalWrite(in4, LOW);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);    //frenar
 
 
 }

 if(estado=='f'){   
  delay(500); 
  digitalWrite(in1, LOW);  
  digitalWrite(in4, HIGH);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);    //Girar ATR derecha
  delay(700);  
  digitalWrite(in1, HIGH);  
  digitalWrite(in4, LOW);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);     //Girar ATR derecha
  delay(700);  
  digitalWrite(in1, LOW);  
  digitalWrite(in4, HIGH);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);    //Girar ATR derecha
  delay(700);  
  digitalWrite(in1, HIGH);  
  digitalWrite(in4, LOW);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW);     //Girar ATR derecha
  delay(700);  
  digitalWrite(in1, HIGH);  
  digitalWrite(in4, HIGH);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW); 
  delay(500);  
  digitalWrite(in1, LOW);  
  digitalWrite(in4, LOW);
  digitalWrite(in2, LOW);
  digitalWrite(in3, LOW); 
 }
}
