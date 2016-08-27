int x=500;
int y=250;
int pixx=10;
int pixy=10;
int score1=0;
int w=250;
int score2=0;
void setup(){
  
 size (1000,500);
  //size (2000,1000);
  fill(8,8,8);

  
}
void draw(){
  
  //background(203, 199, 199);
  rect(950,mouseY, 10, 100);
  ellipse(x,y, 10, 10);
  rect(500,0,10,1000);
  rect(50,w, 10, 100);
  textSize(50);
  text(score1, 580, 64); 
  fill(0, 102, 153);
  
  textSize(50);
  text(score2, 420, 64); 
  fill(0, 102, 153);
  
  
 if(score1 == 10){
   

   
   
 }
   if (keyPressed) {
    if (key == 'w' || key == 'W') {
      w=w-5;
    }
     else {
    w=w;
  }
  }
  if (keyPressed) {
    if (key == 's' || key == 'S') {
      w=w+5;
    }
  }
   if (keyPressed) {
    if (key == ' ' || key == ' ') {
      w=y;
    }
  }
  
if (x <= 0) {
  
       score1 = score1 + 1;
       
       pixx =- pixx;
      
    }
  
  if (x >= 1000) {
  
       score2 = score2 + 1;
       
       pixx =- pixx;
      
    }
  
  if (y == 0 || y == 500) {
      
      pixy =- pixy;
      
      
    }
    
    if (y > mouseY && x > 950 && x < 950 + 100 && y<mouseY + 100) {

      pixx =- pixx;
      
      
    }
    
     if (y > w && x == 50 && x < 50 + 100 && y < w + 100) {

      pixx =- pixx;
      
      
    }
    
  x = x+pixx;

  y = y+pixy;
  
  

  
  
  
  
}