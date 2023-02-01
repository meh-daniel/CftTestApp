# CftTestApp

____

## Основные экраны
| | | |
|:-------------------------:|:-------------------------:|:-------------------------:|
|<img width="1604"  src="https://github.com/meh-daniel/CftTestApp/blob/master/images-for-github/1.jpg"> |  <img width="1604" src="https://github.com/meh-daniel/CftTestApp/blob/master/images-for-github/2.jpg">|<img width="1604" src="https://github.com/meh-daniel/CftTestApp/blob/master/images-for-github/3.jpg">|

____

## Обработка исключений

| | | |
|:-------------------------:|:-------------------------:|:-------------------------:|
|<img width="1604"  src="https://github.com/meh-daniel/CftTestApp/blob/master/images-for-github/4.jpg"> |  <img width="1604" src="https://github.com/meh-daniel/CftTestApp/blob/master/images-for-github/5.jpg">|
____


### Использованные технология и вопросы почему не аналоги
+ Hilt - использовал этот di, так как он самый быстрый по реализации и внедрению его в андроид приложения. Отлично подходит для маленьких и средних приложений. Dagger2 cлишком много б времени занял, а Koin я считаю пока что не достойным своего внимания.

+ lifecycle - отличные библиотеки для реализация presentation слоя. Использовал ибо это стандарт для mvvm архитектур слоя пресентейшейн. Мог б естественно MviCore или Moxy, но не считаю mvp хорошим вариком, а mviCore много на себя архитектуры берёт, тогда как я люблю сам свою чистую архитектуру внедрять в проект.

+ Room - лучшая библиотека для баз данных. Аналогов которые б находились на одном уровне даже не слышал

+ Navigation - навигация от гугла- стандарт тоже, своё или использовать чичерони для навигации не стал, ибо одномодульный проект и гугл опять же сахара добавил.

+ Coroutines - много опыта с корутинами. Мог б RxJava2 использовать, но пока что корутины справляются с моими текущими задачами на моём атусорсе и api не столь сложное чтоб rxjava применять.

+ retrofit2 - стандарт