float left,right,top,bottom;
float middle;

float cueX,cueY,cueDX,cueDY;
float redX,redY,redDX,redDY;
float yelX,yelY,yelDX,yelDY;
float bluX,bluY,bluDX,bluDY;


void setup(){
  size(640,480);
  left=100;
  right= width-25;
  top= 100;
  bottom= height-25;
  middle=left +( right-left)/2;
  //
  reset();
}
void reset(){
    cueX= left + (right-left) / 2;
    cueY= top + (bottom-top) /3;
    //Random Positions.
    redX= random (middle,right); redY= random(top,bottom);
    yelX=  random (middle,right); yelY= random(bottom,middle);
    bluX= random (left,middle); bluY= random(top,bottom);
    //Random speeds
    redDX= random (2,6); redDY= random (2,6);
    yelDX= random (2,6); yelDY= random (2,6);
    bluX = random (2,6); bluX= random (2,6);
  }
  ///Next Frame: table,bounce off walls
  void draw(){
    background(250,250,200);
    rectMode( CORNERS );
    table(left,top,right,bottom);
    bounce();
    collisions();
    show();
    messages();
  }
  void table(float left,float top,float right,float bottom){
   fill(100,250,100);      
   strokeweight (20); 
   stroke(127,0,0);
   rect (left-25,top-25,right+25,botton+20);
   stroke(0);
   strokeweight(1);
  }
  void bounce(){
  redX += redDX;  if ( redX<left || redX>right ) redDX *= -1;
}
void collisions() {
  float tmp;
  // Swap velocities!
  if ( dist( redX,redY, yelX,yelY ) < 50) {
    tmp=yelDX;  yelDX=redDX;  redDX=tmp;
    tmp=yelDY;  yelDY=redDY;  redDY=tmp;
  }
}
void show() {
  fill( 255,255,255 );    ellipse( redX,redY, 30,30 );
  fill( 255,0,0 );    ellipse( redX,redY, 30,30 );
  fill( 255,255,0 );  ellipse( yelX,yelY, 30,30 );
  fill( 0,0,255 );    ellipse( bluX,bluY, 30,30 );
  fill( 255,255,255 );    ellipse( cueX,cueY, 30,30 );
}
void messages() {
  text( title, width/3, 20 );
  text( news, width/3, 40 );
  text( author, 10, height-10 );
}

