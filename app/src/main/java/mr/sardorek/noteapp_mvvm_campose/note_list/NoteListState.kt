package mr.sardorek.noteapp_mvvm_campose.note_list

import mr.sardorek.noteapp_mvvm_campose.entity.Note


data class NoteListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val success: List<Note> = emptyList()
)