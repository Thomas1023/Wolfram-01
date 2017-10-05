int x=400;
int y=400;
int a=0;
int b=0;
int c=0;
int d=0;
int e=0;
int f=0;
int g=0;
int h=0;
int ent=0;
int elf=0;
int gnome=0;
int fairy=0;
int human=0;
int bird=0;
int rock=0;
int paper=0;
int tardis=0;
int i=1000;
int j=1000;
int k=1000;
int l=1000;
int m=1000;
int n=1000;
int o=1000;
int game=0;
int wood=0;
int bug=0;
int air=0;
int ink=0;
int cake=0;
int inch=0;
int ant=0;
PImage img;
PImage sprite;
PImage sprite2;
PImage sprite3;
PImage sprite4;
int club =0;
int cha=0;
int pos=0;
int fla=0;
void setup(){
     sprite = loadImage("sprite.still.png");
     sprite2 = loadImage("sprite.still.back.png");
     sprite3 = loadImage("sprite.still.left.png");
     sprite4 = loadImage("sprite.still.right.png");
     img = loadImage("pokeball 3.png");
  
  size(800,800);
}
void draw(){
   
  if(game==1){
    background(203, 199, 199);
    fill(0,0,0);
    textSize(30);
    text("use the WASD keys to navagate", 200 , 700); 
    textSize(10);
    text("press anykey to continue", 200 , 750); 
    fill(0, 0, 0);
    rect(100,765,624,12);
    rect(100,663,623,12);
    rect(100,670,11,100);
    rect(713,664,11,100);
    
     if (keyPressed) {
       fla=1;
  } 
    
    if(fla==1){
      
    if(pos == 3){
      image(sprite4, x, y, width/20, height/20);
    }
    if(pos == 2){
      image(sprite3, x, y, width/20, height/20);
    }
    if(pos==0){
      image(sprite, x, y, width/20, height/20);
    }
    if(pos==1){
      image(sprite2, x, y, width/20, height/20);
    }
     if (keyPressed) {
    if (key == 'w' || key == 'W') {
      if(pos==1){
          y--;
      }
    pos=1;
    }
  } 
   if (keyPressed) {
    if (key == 's' || key == 'S') {
      if(pos==0){
          y++;
      }
      pos=0;
    }
  } 
   if (keyPressed) {
    if (key == 'a' || key == 'A') {
      if(pos==2){
          x--;
      }
      pos=2;
    }
  } 
   if (keyPressed) {
    if (key == 'd' || key == 'D') {
    if(pos==3){
          x++;
      }
     pos=3;
    }
  } 
    }
  }
  if(game==0){
 

fill(37, 101, 70);
 background(203, 199, 199);
  textSize(70);
  text("Pokéman", 246 , 276); 
  fill(37, 101, 70);
 image(img, 293, 304, width/4, height/4);
 textSize(57);
  
  
   if (keyPressed) {
    if (key == ' ' || key == ' ') {
      ent = 0+1;
    }
  } 
  
  if(ent==1){
     if (a<589){
       a = a+19;
       
       if(a==589){
       elf = 0+1;
       }
       
     }
  }
  if(elf==1){
     if (b<589){
       b = b+19;
       
       if(b==589){
       gnome = 0+1;
       }
       
     }
  }
    if(gnome==1){
     if (c<589){
       c = c+19;
       
       if(c==589){
       fairy = 0+1;
       }
       
     }
  }
    if(fairy==1){
     if (d<589){
       d = d+19;
       
       if(d==589){
       human = 0+1;
       }
       
     }
  }
    if(human==1){
     if (e<589){
       e = e+19;
       
       if(e==589){
       bird = 0+1;
       }
       
     }
  }
    if(bird==1){
     if (f<589){
       f = f+19;
       
       if(f==589){
       paper = 0+1;
       }
       
     }
  }
    if(paper==1){
     if (g<589){
       g = g+19;
       
       if(g==589){
       rock = 0+1;
       }
       
     }
  }
    if(rock==1){
     if (h<589){
       h = h+19;
       
       if(h==589){
       tardis = 0+1;
       }
       
     }
  }

if(club==1){
   if (keyPressed) {
    if (key == 'x' || key == 'X') {
     game=2;
    }
  } 
   if (keyPressed) {
    if (key == 'z' || key == 'Z') {
      game=1;
    }
  } 
}
 if(tardis==1){
     if (i>360){
       i = i-20;
       
       if(i==360){
       wood = 0+1;
       }
       
     }
  }
  
   if(wood==1){
     if (j>400){
       j = j-20;
       
       if(j==400){
       bug = 0+1;
       }
       
     }
  }
  
     if(bug==1){
     if (k>440){
       k = k-20;
       
       if(k==440){
      air = 0+1;
       }
       
     }
  }
     if(air==1){
     if (l>460){
       l = l-20;
       
       if(l==460){
       ink = 0+1;
       }
       
     }
  }
    if(ink==1){
     if (m>480){
       m = m-20;
       
       if(m==480){
       cake = 0+1;
       }
       
     }
  }
     if(cake==1){
     if (n>500){
       n = n-20;
       
       if(n==500){
       inch = 0+1;
       }
       
     }
  }
     if(inch==1){
     if (o>535){
       o = o-15;
       
       if(o==535){
       ant = 0+1;
       }
       
     }
  }
text("t", 168 , a);
text("u", 185 , b);
text("n", 218 , c);
text("g", 251 , d);
text("s", 284 , e);
text("t", 312 , f);
text("e", 332 , g);
text("n", 362 , h);

text("w", i , 657);
text("o", j , 657);
text("l", k , 657);
text("f", l , 657);
text("r", m , 657);
text("a", n , 657);
text("m", o , 657);
if(ant==1){
  fill(0,0,0);
  textSize(30);
  text("press x to skip tutoral", 246 , 100); 
  text("press z to enter tutoral", 246 , 150); 
  club = 1;
  
    }
  
}
  
}