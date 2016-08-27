int elf=0;
int x=500;
int y=250;
int pixx=20;
int pixy=20;
int score1=0;
int score2=0;
int ent=0;
int w=250;
void setup(){
 size (1000,500);
  fill(8,8,8);
}
void draw(){
  
   if (keyPressed) {
    if (key == ' ' || key == ' ') {
  ent=0;
    }
  }
  
  if(ent>=1){
   x=510;
  y=250;   
}
  x = x+pixx;
  y = y+pixy;
  background(23, 199, 199);
  rect(950,mouseY, 10, 100);
  ellipse(x,y, 10, 10);
  rect(500,0,10,1000);
  rect(50,w, 10, 100);
  textSize(50);
  text(score1, 580, 64); 
  textSize(50);
  text(score2, 420, 64); 
  fill(0, 102, 153);

 
  if(elf==1){
      w=y-50;
  }
   if (keyPressed) {
    if (key == 'i' || key == 'I') {
elf=1;
    }
  } 
  
  if (keyPressed) {
    if (key == 'e' || key == 'E') {
elf=0;
    }
  } 
  
  if(elf==0){
    
     if(y>w+50){
    w=w+5; 
  }
  if(y<w+50){
    w=w-5;
  }
    
  }
  
  if (score2 >= 10){
  textSize(75);
  text("winner", 100, 250); 
  if (keyPressed) {
    if (key == 'N' || key == 'n') {
   score1=0;
   score2=0;
    }
  } 
  }
   
  if (score1 >= 10){
  textSize(75);
  text("winner", 600, 250); 
  y=250;
  x=510;
     if (keyPressed) {
    if (key == 'N' || key == 'n') {
   score1=0;
   score2=0;
    }
  }
  }

if (x <= 0) {
      score1 = score1 + 1;
      ent++;  
      pixx =- pixx;
}
    
  if (x >= 1000) {
       score2 = score2 + 1;
       pixx =- pixx;
       ent++;
    }
  if (y <= 0 || y > 500) {
      pixy =- pixy;
    }
    if (y > mouseY && x > 950 && x < 950 + 100 && y<mouseY + 100) {
      pixx =- pixx;
    }
     if (y > w && x == 50 && x < 50 + 100 && y < w + 100) {
      pixx =- pixx;
    }
 

      
    
  
    }
  