package com.palzzak.blur.data.source.local

import com.palzzak.blur.data.Message
import com.palzzak.blur.data.source.MessagesDataSource
import com.palzzak.blur.util.CoroutineContexts
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

/**
 * Created by yooas on 2018-01-19.
 */
class MessagesLocalDataSource: MessagesDataSource {
    @Inject
    lateinit var mCoroutineContexts: CoroutineContexts

    @Inject
    lateinit var mMessageDao: MessageDao

    override fun getMessages(roomId: Long, offset: Long, callback: MessagesDataSource.LoadMessagesCallback) {
        launch(mCoroutineContexts.diskIO()) {
            val messages = mMessageDao.getMessages()
            /*launch(UI) {
                callback.onMessagesLoaded(messages)
            }*/
        }
    }

    override fun saveMessage(message: Message) {
        launch(mCoroutineContexts.diskIO()) {
            mMessageDao.insertMessage(message)
        }
    }

    override fun deleteAllMessages() {
        launch(mCoroutineContexts.diskIO()) {
            mMessageDao.deleteMessages()
            TODO("Delete audio files")
        }
    }

    override fun deleteMessage(id: Long) {
        launch(mCoroutineContexts.diskIO()) {
            mMessageDao.deleteMessageById(id)
            TODO("Delete audio file")
        }
    }
}