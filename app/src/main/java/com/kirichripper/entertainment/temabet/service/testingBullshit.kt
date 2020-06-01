package com.kirichripper.entertainment.temabet.service

import com.kirichripper.entertainment.temabet.data.Horse
import com.kirichripper.entertainment.temabet.data.Run


//to test list with horses, in future this will be replaced by data from the request to server
fun initHorsesList(): List<Horse>{
    val horse1 = Horse(1,"John","Tema",12, 0.5,1.2,1213)
    val horse2 = Horse(2,"John Wick","Tema2",13, 0.56,1.2,2343)
    val horse3 = Horse(3,"Mark","Tema3",12, 0.8,1.05,2223)
    val horse4 = Horse(4,"Houston","Tema4",13, 0.2,1.5,233)
    val horse5 = Horse(5,"Tema","Tema",12, 0.5,1.2,1213)
    val horse6 = Horse(6,"Tema2","Tema2",13, 0.56,1.2,2343)
    val horse7 = Horse(7,"Tema3","Tema3",12, 0.8,1.05,2223)
    val horse8 = Horse(8,"Tema3210","Tema4",13, 0.2,1.5,233)

    return listOf(horse1,horse2,horse3,horse4,horse5,horse6,horse7,horse8)
}


//to test list with runs, in future this will be replaced by data from the request to server
fun initRunList(): List<Run>{
    val run1 = Run(12342,"19.12.2054","Bakaievka",initHorsesList())
    val run2 = Run(123452,"19.12.2054","Bakaievka",initHorsesList())
    val run3 = Run(1235442,"14.12.2054","Bakaievka",initHorsesList())
    val run4 = Run(1234122,"16.12.2054","Bakaievka",initHorsesList())
    val run5 = Run(123142,"19.08.2054","Bakaievka",initHorsesList())
    val run6 = Run(123412,"20.09.2054","Bakaievka",initHorsesList())
    val run7 = Run(1234452,"20.10.2054","Bakaievka",initHorsesList())
    val run8 = Run(123432,"20.11.2054","Bakaievka",initHorsesList())
    val run9 = Run(12,"20.12.2054","Bakaievka",initHorsesList())


    return listOf(run1,run2,run3,run4,run5,run6,run7,run8,run9)
}
