package com.curso.proyecto1.view


import androidx.test.espresso.Espresso
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.proyecto1.R
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)
    @Before
    fun setUp() {
    }
    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_comparaTexto() {
        Espresso.onView(
            ViewMatchers.withId(R.id.compara_btn)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
     ViewMatchers.withId(R.id.texto1)
    ).perform(
     TypeTextAction("ora")
    //TypeTextAction("hola")
    )
    Espresso.onView(
    ViewMatchers.withId(R.id.texto2)
    ).perform(
    TypeTextAction("ora")
    )

    Espresso.onView(
    ViewMatchers.withId(R.id.resultado)
    )
    }
}



