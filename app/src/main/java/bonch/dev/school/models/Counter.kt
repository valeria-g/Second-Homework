package bonch.dev.school.models

class Counter(startCount: Int = 0) {

    var currentCount = startCount
        private set

    fun increment(){
        ++currentCount
    }

}