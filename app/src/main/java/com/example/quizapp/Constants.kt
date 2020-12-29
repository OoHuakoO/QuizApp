package com.example.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(1,"What country does this flag belong to?",
            R.drawable.flag_argentina,"Argentina","Australia","Brazil","Thailand"
        ,1
        )
        questionList.add(que1)
        val que2 = Question(2,"What country does this flag belong to?",
            R.drawable.flag_denmark,"Belarus","Australia","Denmark","Germany"
            ,3
        )
        questionList.add(que2)
        val que3 = Question(3,"What country does this flag belong to?",
            R.drawable.flag_italy,"Hungary","Italy","France","Bulgaria"
            ,2
        )
        questionList.add(que3)
        val que4 = Question(4,"What country does this flag belong to?",
            R.drawable.flag_brazill,"Iceland","Hungary","Brazil","Thailand"
            ,3
        )
        questionList.add(que4)
        val que5 = Question(5,"What country does this flag belong to?",
            R.drawable.flag_thailand,"Australia","Bulgaria","Croatia","Thailand"
            ,4
        )
        questionList.add(que5)
        val que6 = Question(6,"What country does this flag belong to?",
            R.drawable.flag_russia,"Andorra","Belarus","Russia","Spain"
            ,3
        )
        questionList.add(que6)
        val que7 = Question(7,"What country does this flag belong to?",
            R.drawable.flag_portugal,"Portugal","Romania","Brazil","Spain"
            ,1
        )
        questionList.add(que7)
        val que8 = Question(8,"What country does this flag belong to?",
            R.drawable.flag_spain,"Serbia","Spain","Sweden","Monaco"
            ,2
        )
        questionList.add(que8)
        val que9 = Question(9,"What country does this flag belong to?",
            R.drawable.flag_france,"Ireland","Greece","France","Belarus"
            ,3
        )
        questionList.add(que9)
        val que10 = Question(10,"What country does this flag belong to?",
            R.drawable.flag_germany,"Albania","Czech Republic","Croatia","Germany"
            ,4
        )
        questionList.add(que10)
        return questionList
    }


}