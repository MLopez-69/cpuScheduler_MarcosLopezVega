# cpuScheduler

Hello and welcome to my cpu scheduler. this program is made to mimic the way the CPU of a computer schedules processes

In this readme I will explain each algorithm in detail as well as explain how to operate the program. 


# how to use the program

As the program opens. The first thing you should see is the main screen, where the first algorithm is the First In First Served algorithm. 

## selecting a number of processes

in the top left corner there should be a combobox with a label next to it that says "number of processes". simply select it and select any number from 1 to 10

the program will then simply set those processes visible and allow the user to input the burst times (and priority if in the priority scheduler)

## inputting burst times and priority

to input the burst times and priority, simply enter a number into the respective textfield, ensuring that you enter a number into all of them before calculating

## random burst times

the random burst times button found on the right-hand side fills in any and all text fields available (with the exception of priority fields) and 
inputs a random value for them from one to 50

##calculate

Finally, to calculate, simply press the calculate button and watch the program go


#Algorithms

##Gantt cell and process

The class process is made to hold the process itself. However, the class gantt cell was originally made so that the process would be flexible.
You see, originally, the gantt cell class was only going to be used in the FIFS data structure, however, it proved to be more useful later on.


##First In First Out(FIFS) Algorithm

The first in First Served algorithm was by far the easiest of all of them to implement. it took longer to build the javafx and get everything set up.
The data structure I used for this is a linked list. The reason i chose this for the data structure is because since i was placing items in a queue,
i found it easier to use a linked list as i was simply appending the processes into the end of the list and popping the first node, something a linked list
is very good at. Moreover, the algorithm by far had the easiest way to calculate wait time and TA Time, as well as the easiest way to set the times.

the wait time and TA time are calculated by going through the linked list and adding wither the wait time or Turn Around time and then later dividing it by
the max number of processes, or max. The wait time and Turnaround time were set by iterating through the list and setting the wait time to the previous
TurnAround time, and then adding the current times burst time, and then setting the processes TAtime to the previousTATime

For the gantt chart, all i had to do was set as many labels as the number in the process box

##Short Job First(SJF) Algorithm

I had initially thought this would be easy as the first algorithm, however I ran into some challenges. The first challenge i ran arose from using a different 
data structure. I thought using a hashMap would be best suited for this algorithm, as the elements in the map would automatically get sorted by the data
structure. The reason i was looking fo this is because when it comes to calculating wait time, TurnAround time, and their averages, as well as setting each
processes times, it would be ideal to have the elements sorted by their burst times. the first issue i ran here was figuring out how to calculate the 
wait times, turnaround times and how to set their times. I had to make some changes to what I had originally.

The new way to set the process's time involves now getting what the largest burst time is. once we have that saved, we then make a while loop where the program will
increase the counter until it reaches greater than the max burst time. within that loop, we have another loop where we iterate through the map and if the
the burst time of the current cell matches the burst time counter of the parent while loop, then we do what we did for the other algorithm to set the times.
The calculations for both averages remained mostly unchanged, with perhaps some minor modifications if any.

The next issue that I ran into was how to allow for duplicate burst times. I realized that the algorithm had issues taking duplicate burst times.
My solution to this bug was to change how the algorithm maps the elements. It was at this point where I had to make the priority variable for the gantt cell.
I would also create another variable in the Short Job First algorithm named processcount, whose purpose is to assign a number to each variable as they come in.
this would work for my setTimes method, but i also had to add in there something so that i could set the priority of each gantt cell.
Each cell was assigned a priority. This resolved the issue and allowed for duplicate burst times to exist.

The gantt chart was a struggle based on the past two issues. However, here is where the priority comes in handy. as you iterate through the map, what the controller
does is that it looks for the priority of each mapped element, then it matches it to a label and sets that label to the processes name.

##Priority Algorithm

For this algorithm, i Initially wanted it to be another map structure, however I decided against that after seeing the issues that arose with using A map for the SJF algorithm.
So I decided that going back to a linked list would have been ideal. Ultimately, this would prove to be better, because it gave me the freedom to implement what I learned with the previous algorithm without having to worry about changing another structure.
When i had to calculate wait time and turnaround time, what i did was i used the same code as the first algorithm, however i had to make a few changes as this algorithm had
different variables in the new structure, which is ideally what you'd want. 

Process count now held the max number of processes, priorityMax now held the maximum priority value. One important thing to note here is that the way my priority algorithm works is that it sets the lowest number as the highest priority. So the lower the number, the higher the priority. 

The setTimes method for this structure is where the majority of the changes lie. The setTimes method sets the wait times and turnaround times by having two while loops, like in the previous example. The outer loop runs through the numbers between the lowest priority to the highest whereas the inner loop iterates through the linked list, setting
the times to an element if that element's priority corresponds with the current priority count. This not only serves to set the times, but it also accounts for duplicates
which would otherwise break the program.
