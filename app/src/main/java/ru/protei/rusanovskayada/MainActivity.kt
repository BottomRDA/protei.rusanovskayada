package ru.protei.rusanovskayada

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.protei.rusanovskayada.domain.Note
import ru.protei.rusanovskayada.ui.theme.RusanovskayadaTheme

class MainActivity : ComponentActivity() {

    val notes = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {

        notes.add(Note("1 Заметка", "Заметки созданы РусановскойДА"))
        notes.add(Note("2 Заметка", "Создаю приложение в AndroidStudio первый раз!"))
        notes.add(Note("3 Заметка", "Вроде что-то получилось!"))

        super.onCreate(savedInstanceState)
        setContent {
            RusanovskayadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NoteDisplay(notes)
                }
            }
        }
    }
}

@Composable
fun NoteDisplay(notes: MutableList<Note>, modifier: Modifier = Modifier) {
    
    var text = ""   
    for (note in notes)
    {
        text += note.title + "\n" + note.text + "\n\n"
    }

    Text(
        text ="$text",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RusanovskayadaTheme {

    }
}