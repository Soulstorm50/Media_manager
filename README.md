Медиа менеджер
Необходимо создать консольный медиа менеджер, для управления статусом контента: книги, музыка и фильмы. Можно дополнять программу своим функционалом, тесты можно не писать.
Ждем ссылку на исходники в GH и работающий jar файл

Возможности:
1. Внести в список книгу/музыку/фильм
2. Изменить статус для книги/музыки/фильма
3. Вывести список книг/музыки/фильма фильтрованный и не фильтрованный по статусу
4. Удалить книгу/музыку фильм

Статусы для книги
Прочитал
Хочу прочитать
Читаю сейчас
Для музыки и фильмов аналогично

Пример работы приложения

$ manager add “Harry Potter”
What is “Harry Potter”?
1. Book
2. Film
3. Music
Type answer

$ manager status “Harry Potter”
1. Harry Potter book status “WANT READ”
2. Harry Potter film status “WATCHED”

$ manager add status “Harry Potter”
1. Harry Potter book
2. Harry Potter film
Type answer

$ manager print books
“Harry Potter”
