package mr.sardorek.noteapp_mvvm_campose.detail_scree

import mr.sardorek.noteapp_mvvm_campose.entity.Note


sealed class DetailEvent {
    data class GetNoteById(val id: Int): DetailEvent()
    data class SaveNote(val note: Note): DetailEvent()
    data class UpdateNote(val note: Note): DetailEvent()
    data class DeleteNote(val note: Note): DetailEvent()
}