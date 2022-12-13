package mr.sardorek.noteapp_mvvm_campose.screen

sealed class Screen(
    val route: String
) {
    object Home: Screen(
        route = "home_screen"
    )
    object Detail: Screen(
        route = "add_update_screen"
    )
}
