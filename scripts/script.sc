set school = schoolPlayground.jpg
set classroom = classroom.jpg
set teacher = male.png
set friendSmile = friendSmile.png
set friend = friend.png
set friend2 = friend2.png
set girl = girl.png
set girlSmile = girlSmile.png

bg #{school}
msg Me First standing inside of this high school in which I'll be spending the next three years, I still cannot believe that I was a middle school student two months ago. Time flies. 

msg Me Don't know what my high school life would be. 

bg #{classroom}
msg Me (So many people here. The seat at the window seems nice. Guess I'll just sit there. )

cg #{teacher}
msg Mr.Peng Everybody sit down.

msg Mr.Peng Hello, everyone. I'm your head teacher. You can call me Mr.Peng. I'm sure that you guys had a great summer. From now on, everybody's become a high school student, which means that you are becoming grown-ups while facing cruel competitions at the same time. 

msg Mr.Peng You'll also have to learn how to address the relationships between each other because grades are not everything, as a matter of fact...­

msg Mr.Peng Hope you would have a happy and meaningful high school life. 

cg del
msg Me God, why do all head teachers like to give such a long speech? 

cg #{friendSmile}
msg ? Yo, you also here? How come I didn't see you? 

msg Me Oh, I was fiddling with my cellphone, so...­

msg Me (This is my middle school classmate named Patrick. He's a nice guy, but I didn't talk to him much, to be honest.)

msg Patrick God, I cannot believe that Mr.Peng'd talked so much about the college entrance test during the first day of school. I feel kind of stupid that I was expecting a beautiful high school life. 

msg Me Haha, I feel the same way. Is it just us who were classmates before? 

msg Patrick Two extra girls I think, but I didn't even talk to them at middle school. 

msg Me Yea. Me, either. 

msg Patrick Have you noticed any pretty girls?

msg Me Eh, not really. I was playing a mobile game. 

msg Patrick C'mon, man. The first thing you'll need to do when you got to a new place is to look for girls that are attractive to every single male. This is extremely important since we're spending three years in this class. 

msg Me ...

cg del #{friendSmile}
cg #{friend}
msg Patrick Why you staring at me like that?

msg Me Nothing. 

msg Patrick Were you thinking, "He's probably an idiot."? 

msg Me No, I was not. Seriously. 

msg Patrick Don't lie to me, man. 

msg Me Dude, how many time do I have to tell you that I was not thinking about that at all? 

cg del
msg Me (I kept talking to him until the class began. It feels not bad when you know somebody in a new place. )

cg #{girl}
msg ? Are you drawing something?

msg Me Yea...

msg ? You like cars?

msg Me Sort of. I just draw them whenever I'm free.

msg ? Can I take a look at it?

msg Me Sure...

msg ? This looks gorgeous! Have you learned drawing pictures before?

msg Me I did for a few years during the middle school, but then I quit.

msg ? Why's that?

msg Me No particular reasons. I preferred to treat it as a hobby, I guess. And I really didn't like the way of sitting on a chair to draw the stupid plaster of figures for several hours.

cg del #{girl}
cg #{girlSmile}
msg ? Haha.

cg del
cg #{girl}
msg Ivy I forgot to introduce myself. My name's Ivy. Nice to meet you.

msg Me Hi.

msg Ivy Why don't you introduce yourself?

msg Me My name's Jack. Nice to meet you. 

cg del
cg #{girlSmile}
msg Ivy Glad talking to you. I'll talk to you later. Time for the class.

msg Me Okay. 

cg del
cg #{friend2}
msg Patrick Wanna have some fun this weekend?

msg Me Where? I don't care.

msg Patrick To the amusement park?

msg Me Sure. Haven't been there for a long time.

cg del #{friend2}
cg #{girl}
msg Ivy I don't really want to go, to be honest. I prefer to stay at home and study for the upcoming test next week.

select
a. Invite her
b. Give up

msg Me Don't say that. Come with us. Me + him = boring.

cg del #{girl}
cg #{friend}
msg Patrick Wow, I can't pretend that I didn't hear that.

cg del #{friend}
cg #{girl}
msg Ivy Alright. When should we go then?

cg del #{girl}
cg #{friend2}
msg Patrick Saturday at 10?

msg Me Cool.

cg del #{friend2}
cg #{girlSmile}
msg Ivy Okay.
