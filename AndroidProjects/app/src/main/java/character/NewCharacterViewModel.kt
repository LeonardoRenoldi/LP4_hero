package character

import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.Character

class NewCharacterViewModel : ViewModel() {

    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    fun validateCharacter (character: Character) {
        if (character.name.isNullOrEmpty() || character.description.isNullOrEmpty()  || character.date.isNullOrEmpty() || character.image.isNullOrEmpty() || character.universeType.isNullOrEmpty() || character.characterType.isNullOrEmpty()){
            state.value = ViewState.ShowError
        } else{
            state.value = ViewState.ShowSuccess
        }
    }

    sealed class ViewState {
        object ShowError : ViewState()
        object ShowSuccess : ViewState()
    }
}