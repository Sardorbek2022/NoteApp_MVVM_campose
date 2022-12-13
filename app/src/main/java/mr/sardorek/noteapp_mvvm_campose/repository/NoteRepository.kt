package mr.sardorek.noteapp_mvvm_campose.repository

import android.provider.ContactsContract
import mr.sardorek.noteapp_mvvm_campose.database.NoteDao
import mr.sardorek.noteapp_mvvm_campose.entity.Note

class NoteRepository(
    private val dao: NoteDao
) {
    suspend fun saveNote(note: Note) = dao.saveNote(note)
    suspend fun deleteNote(note: Note) = dao.deleteNote(note)
    fun getAllNotes() = dao.getAllNotes()
    suspend fun updateNote(note: Note) = dao.updateNote(note)
    suspend fun getNoteById(id: Int) = dao.getNoteById(id)
}