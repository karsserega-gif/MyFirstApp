package ru.karsakov.myfirstapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.karsakov.myfirstapp.dto.Post
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PostRepositoryInMemoryImpl : PostRepository {

    private var nextId = 5L
    private val currentUserId = 1L
    private val currentUserName = "Я"

    private var posts = listOf(
        Post(
            id = 1,
            author = "Кибердружина",
            authorId = 2,
            content = "Уникальное сообщество неравнодушных людей, которые ведут борьбу с вопиющими случаями нарушения прав человека в интернет-пространстве." ,
            published = "21 мая в 18:36",
            likedByMe = false,
            likes = 999,
            shares = 25,
            views = 5700,
            video = null
        ),

        Post(
            id = 2,
            author = "Обновление",
            authorId = 3,
            content = "Теперь пользоваться платформой стало ещё удобнее, быстрее и понятнее. Мы учли ваши пожелания и сделали интерфейс максимально дружелюбным для всех участников движения.",
            published = "22 мая в 10:15",
            likedByMe = false,
            likes = 342,
            shares = 89,
            views = 2300,
            video = "https://rutube.ru/video/73a38c004a0c97f0356fd49a832e52ec/"  // пример видео
        ),

        Post(
            id = 3,
            author = "Надзор",
            authorId = 4,
            content = "В ходе очередного мониторинга популярных интернет-сообществ активисты кибердружины обнаружили в одной из известных групп факты распространения нежелательных и потенциально опасных высказываний. В публикациях были замечены призывы к нарушению общественного порядка, а также комментарии, разжигающие вражду и нетерпимость." ,
            published = "23 мая в 09:42",
            likedByMe = true,
            likes = 1250,
            shares = 420,
            views = 8900,
            video = null
        ),

        Post(
            id = 4,
            author = "Пополнение",
            authorId = 5,
            content = "Цифры говорят сами за себя: интерес к кибербезопасности растёт с каждым днём. Только за последний месяц в ряды нашей кибердружины вступило более 5 000 новых участников. Это не просто статистика — это тысячи неравнодушных людей, которые решили сделать интернет безопаснее для себя, своих близких и всех пользователей.",
            published = "22 мая в 19:00",
            likedByMe = false,
            likes = 5678,
            shares = 1234,
            views = 45000,
            video = null
        ),
        Post(
            id = 5,
            author = "Новый рекорд по выявлению фишинга!",
            authorId = 6,
            content = "За последние сутки кибердружинники обнаружили и обработали более 100 подозрительных ссылок. Все они были направлены на фишинг — кражу паролей и данных банковских карт. Дружинники оперативно предупредили пользователей в социальных сетях и направили информацию в службу безопасности для блокировки ресурсов.",
            published = "23 мая в 17:08",
            likedByMe = false,
            likes = 2345,
            shares = 1256,
            views = 23000,
            video = null
        ),
        Post(
            id = 6,
            author = "В кибердружину — за безопасностью!",
            authorId = 7,
            content = "Стартовал новый набор в ряды кибердружины. Организаторы приглашают всех желающих присоединиться к движению за безопасный интернет. Участникам обещают обучение, поддержку специалистов и возможность внести реальный вклад в защиту цифрового пространства своего города.",
            published = "24 мая в 9:42",
            likedByMe = false,
            likes = 8237,
            shares = 1234,
            views = 36000,
            video = null
        ),
        Post(
            id = 7,
            author = "Урок безопасности в школе №12",
            authorId = 8,
            content = "Волонтёры кибердружины провели открытый урок для старшеклассников школы №12. Ребята узнали, как защитить свои аккаунты, распознать мошенников и не стать жертвой интернет-угроз. Встреча прошла в формате диалога: школьники задавали вопросы и делились своим опытом.",
            published = "25 мая в 13:37",
            likedByMe = false,
            likes = 7833,
            shares = 1645,
            views = 30000,
            video = null
        ),
        Post(
            id = 8,
            author = "Совместная операция с IT-специалистами",
            authorId = 9,
            content = "Кибердружина совместно с IT-специалистами предотвратила крупную кибератаку на школьную сеть города. Благодаря вовремя полученной информации от волонтёров удалось оперативно отразить угрозу и защитить данные учеников и учителей.",
            published = "25 мая в 23:02",
            likedByMe = false,
            likes = 7643,
            shares = 2789,
            views = 23478,
            video = null
        ),
        Post(
            id = 9,
            author = "Кибердружина на страже порядка!",
            authorId = 10,
            content = "На этой неделе активисты кибердружины проявили высокую бдительность. Благодаря их оперативной работе были выявлены и заблокированы несколько мошеннических сайтов, которые пытались выманить личные данные у пользователей. Специалисты отмечают, что своевременное реагирование помогло предотвратить возможные финансовые потери и утечки информации.",
            published = "26 мая в 16:27",
            likedByMe = false,
            likes = 5633,
            shares = 763,
            views = 50000,
            video = null
        ),
        Post(
            id = 10,
            author = "Награждение лучших ибердружинников",
            authorId = 11,
            content = "В администрации города прошло торжественное награждение лучших волонтёров кибердружины. За вклад в цифровую безопасность активисты получили почётные грамоты и памятные подарки. Организаторы отметили, что движение набирает популярность и становится по-настоящему народным.",
            published = "27 мая в 14:18",
            likedByMe = false,
            likes = 10079,
            shares = 3665,
            views = 60000,
            video = null
        )

    )

    private val _data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = _data

    override fun likeById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(
                    likedByMe = !post.likedByMe,
                    likes = if (post.likedByMe) post.likes - 1 else post.likes + 1
                )
            } else {
                post
            }
        }
        _data.value = posts
    }

    override fun shareById(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(shares = post.shares + 1)
            } else {
                post
            }
        }
        _data.value = posts
    }

    override fun increaseViews(id: Long) {
        posts = posts.map { post ->
            if (post.id == id) {
                post.copy(views = post.views + 1)
            } else {
                post
            }
        }
        _data.value = posts
    }

    override fun save(post: Post) {
        if (post.id == 0L) {
            // Создание нового поста
            val newPost = post.copy(
                id = nextId++,
                author = currentUserName,
                authorId = currentUserId,
                published = formatDate(Date()),
                likedByMe = false,
                likes = 0,
                shares = 0,
                views = 0
            )
            posts = listOf(newPost) + posts
        } else {
            // Обновление существующего поста
            posts = posts.map { existingPost ->
                if (existingPost.id == post.id) {
                    // Сохраняем автора, дату и счетчики, обновляем только контент
                    existingPost.copy(content = post.content)
                } else {
                    existingPost
                }
            }
        }
        _data.value = posts
    }

    override fun removeById(id: Long) {
        posts = posts.filter { it.id != id }
        _data.value = posts
    }

    private fun formatDate(date: Date): String {
        val format = SimpleDateFormat("d MMM в HH:mm", Locale("ru"))
        return format.format(date)
    }
}


