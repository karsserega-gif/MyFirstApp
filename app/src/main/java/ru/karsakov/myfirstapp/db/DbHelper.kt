package ru.karsakov.myfirstapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ru.karsakov.myfirstapp.db.PostContract.Columns

class DbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "myfirstapp.db"
        private const val DATABASE_VERSION = 1

        // SQL для создания таблицы
        private const val SQL_CREATE_POSTS =
            "CREATE TABLE ${PostContract.TABLE_NAME} (" +
                    "${Columns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${Columns.AUTHOR} TEXT NOT NULL," +
                    "${Columns.AUTHOR_ID} INTEGER NOT NULL," +
                    "${Columns.CONTENT} TEXT NOT NULL," +
                    "${Columns.PUBLISHED} TEXT NOT NULL," +
                    "${Columns.LIKED_BY_ME} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.LIKES} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.SHARES} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.VIEWS} INTEGER NOT NULL DEFAULT 0," +
                    "${Columns.VIDEO} TEXT" +
                    ")"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Создаем таблицу при первом запуске
        db.execSQL(SQL_CREATE_POSTS)

        // Здесь можно добавить начальные данные
        insertInitialData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // При обновлении версии удаляем старую таблицу и создаем новую
        // В реальном проекте здесь должна быть миграция данных
        db.execSQL("DROP TABLE IF EXISTS ${PostContract.TABLE_NAME}")
        onCreate(db)
    }

    private fun insertInitialData(db: SQLiteDatabase) {
        // Вставляем начальные посты для демонстрации
        val contentValues = android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Кибердружина")
            put(Columns.AUTHOR_ID, 2)
            put(Columns.CONTENT, "Уникальное сообщество неравнодушных людей, которые ведут борьбу с вопиющими случаями нарушения прав человека в интернет-пространстве.")
            put(Columns.PUBLISHED, "21 мая в 18:36")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 999)
            put(Columns.SHARES, 25)
            put(Columns.VIEWS, 5700)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }


        // Второй пост с видео
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Обновление")
            put(Columns.AUTHOR_ID, 3)
            put(Columns.CONTENT, "Теперь пользоваться платформой стало ещё удобнее, быстрее и понятнее. Мы учли ваши пожелания и сделали интерфейс максимально дружелюбным для всех участников движения.")
            put(Columns.PUBLISHED, "22 мая в 10:15")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 342)
            put(Columns.SHARES, 89)
            put(Columns.VIEWS, 2300)
            put(Columns.VIDEO, "https://rutube.ru/video/73a38c004a0c97f0356fd49a832e52ec/")
            db.insert(PostContract.TABLE_NAME, null, this)
        }
        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Надзор")
            put(Columns.AUTHOR_ID, 4)
            put(Columns.CONTENT, "В ходе очередного мониторинга популярных интернет-сообществ активисты кибердружины обнаружили в одной из известных групп факты распространения нежелательных и потенциально опасных высказываний. В публикациях были замечены призывы к нарушению общественного порядка, а также комментарии, разжигающие вражду и нетерпимость.")
            put(Columns.PUBLISHED, "23 мая в 09:42")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 1250)
            put(Columns.SHARES, 420)
            put(Columns.VIEWS, 8900)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }


        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Пополнение")
            put(Columns.AUTHOR_ID, 5)
            put(Columns.CONTENT, "Цифры говорят сами за себя: интерес к кибербезопасности растёт с каждым днём. Только за последний месяц в ряды нашей кибердружины вступило более 5 000 новых участников. Это не просто статистика — это тысячи неравнодушных людей, которые решили сделать интернет безопаснее для себя, своих близких и всех пользователей.")
            put(Columns.PUBLISHED, "22 мая в 19:00")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 5678)
            put(Columns.SHARES, 1234)
            put(Columns.VIEWS, 45000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }


        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Новый рекорд по выявлению фишинга!")
            put(Columns.AUTHOR_ID, 6)
            put(Columns.CONTENT, "За последние сутки кибердружинники обнаружили и обработали более 100 подозрительных ссылок. Все они были направлены на фишинг — кражу паролей и данных банковских карт. Дружинники оперативно предупредили пользователей в социальных сетях и направили информацию в службу безопасности для блокировки ресурсов.")
            put(Columns.PUBLISHED, "23 мая в 17:08")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 2345)
            put(Columns.SHARES, 1256)
            put(Columns.VIEWS, 23000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }


        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "В кибердружину — за безопасностью!")
            put(Columns.AUTHOR_ID, 7)
            put(Columns.CONTENT, "Стартовал новый набор в ряды кибердружины. Организаторы приглашают всех желающих присоединиться к движению за безопасный интернет. Участникам обещают обучение, поддержку специалистов и возможность внести реальный вклад в защиту цифрового пространства своего города.")
            put(Columns.PUBLISHED, "24 мая в 9:42")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 8237)
            put(Columns.SHARES, 1234)
            put(Columns.VIEWS, 36000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }

        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Урок безопасности в школе №12")
            put(Columns.AUTHOR_ID, 8)
            put(Columns.CONTENT, "Волонтёры кибердружины провели открытый урок для старшеклассников школы №12. Ребята узнали, как защитить свои аккаунты, распознать мошенников и не стать жертвой интернет-угроз. Встреча прошла в формате диалога: школьники задавали вопросы и делились своим опытом.")
            put(Columns.PUBLISHED, "25 мая в 13:37")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 7833)
            put(Columns.SHARES, 1645)
            put(Columns.VIEWS, 30000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }


        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Совместная операция с IT-специалистами")
            put(Columns.AUTHOR_ID, 9)
            put(Columns.CONTENT, "Кибердружина совместно с IT-специалистами предотвратила крупную кибератаку на школьную сеть города. Благодаря вовремя полученной информации от волонтёров удалось оперативно отразить угрозу и защитить данные учеников и учителей.")
            put(Columns.PUBLISHED, "25 мая в 23:02")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 7643)
            put(Columns.SHARES, 2789)
            put(Columns.VIEWS, 23478)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }


        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Кибердружина на страже порядка!")
            put(Columns.AUTHOR_ID, 10)
            put(Columns.CONTENT, "На этой неделе активисты кибердружины проявили высокую бдительность. Благодаря их оперативной работе были выявлены и заблокированы несколько мошеннических сайтов, которые пытались выманить личные данные у пользователей. Специалисты отмечают, что своевременное реагирование помогло предотвратить возможные финансовые потери и утечки информации.")
            put(Columns.PUBLISHED, "26 мая в 16:27")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 5633)
            put(Columns.SHARES, 763)
            put(Columns.VIEWS, 50000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }


        android.content.ContentValues().apply {
            put(Columns.AUTHOR, "Награждение лучших Кибердружинников")
            put(Columns.AUTHOR_ID, 11)
            put(Columns.CONTENT, "В администрации города прошло торжественное награждение лучших волонтёров кибердружины. За вклад в цифровую безопасность активисты получили почётные грамоты и памятные подарки. Организаторы отметили, что движение набирает популярность и становится по-настоящему народным.")
            put(Columns.PUBLISHED, "27 мая в 14:18")
            put(Columns.LIKED_BY_ME, 0)
            put(Columns.LIKES, 10079)
            put(Columns.SHARES, 3665)
            put(Columns.VIEWS, 60000)
            putNull(Columns.VIDEO)
            db.insert(PostContract.TABLE_NAME, null, this)
        }



    }
}
