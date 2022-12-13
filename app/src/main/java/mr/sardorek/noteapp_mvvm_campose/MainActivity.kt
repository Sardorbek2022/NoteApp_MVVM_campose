package mr.sardorek.noteapp_mvvm_campose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mr.sardorek.noteapp_mvvm_campose.database.NoteDatabase
import mr.sardorek.noteapp_mvvm_campose.detail_scree.DetailScreen
import mr.sardorek.noteapp_mvvm_campose.detail_scree.DetailViewModel
import mr.sardorek.noteapp_mvvm_campose.detail_scree.DetailViewModelFactory
import mr.sardorek.noteapp_mvvm_campose.note_list.NoteListScreen
import mr.sardorek.noteapp_mvvm_campose.note_list.NoteListViewModel
import mr.sardorek.noteapp_mvvm_campose.note_list.NoteViewModelFactory
import mr.sardorek.noteapp_mvvm_campose.repository.NoteRepository
import mr.sardorek.noteapp_mvvm_campose.screen.Screen
import mr.sardorek.noteapp_mvvm_campose.ui.theme.NoteAppWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = NoteDatabase.invoke(this).dao
        val repository = NoteRepository(dao)
        val noteListViewModelFactory = NoteViewModelFactory(repository)
        val detailViewModelFactory = DetailViewModelFactory(repository)
        val noteListViewModel =
            ViewModelProvider(this, noteListViewModelFactory)[NoteListViewModel::class.java]
        val detailViewModel =
            ViewModelProvider(this, detailViewModelFactory)[DetailViewModel::class.java]
        setContent {
            NoteAppWithComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navHostController = rememberNavController()
                    NavHost(
                        navController = navHostController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(route = Screen.Home.route) {
                            NoteListScreen(navHostController, noteListViewModel)
                        }
                        composable(
                            route = "${Screen.Detail.route}/{id}/{title}/{content}",
                            arguments = listOf(
                                navArgument(
                                    name = "id"
                                ) {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val id = it.arguments?.getInt("id") ?: -1
                            val title = it.arguments?.getString("title") ?: ""
                            val content = it.arguments?.getString("content") ?: ""
                            DetailScreen(
                                navHostController = navHostController,
                                id = id,
                                _title = title,
                                _content = content,
                                viewModel = detailViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}
