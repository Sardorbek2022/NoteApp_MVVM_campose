package mr.sardorek.noteapp_mvvm_campose.detail_scree

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mr.sardorek.noteapp_mvvm_campose.repository.NoteRepository

class DetailViewModelFactory(
    private val repository: NoteRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(repository) as T
    }
}