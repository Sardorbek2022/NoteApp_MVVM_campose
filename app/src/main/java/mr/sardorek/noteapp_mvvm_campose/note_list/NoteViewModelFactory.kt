package mr.sardorek.noteapp_mvvm_campose.note_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mr.sardorek.noteapp_mvvm_campose.repository.NoteRepository

class NoteViewModelFactory(
    private val repository: NoteRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteListViewModel(repository) as T
    }
}