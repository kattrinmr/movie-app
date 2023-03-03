# Test task Tinkoff Android Fintech 2023

## Description
Write an Android application with a list of movies and their descriptions. 
[The unofficial movie search API](https://kinopoiskapiunofficial.tech/) is used as a data source.  

## Implementation
The application is written in Kotlin.  
Stack: MVVM, Coroutines, Flow, Retrofit 2, Room, Dagger 2, Jetpack Navigation, Glide.  

Implemented:  
* displaying a list of popular films in the "Popular" section, when you click on a card with a film, a screen opens with a movie poster, description, genre, country of production;
* with a long click, the card from the films is added to favorites; displaying a list of favorite films in the "Favorites" section;
* notifying the user that the network is unavailable; favorite cards are available offline, popular cards are cached for the duration of the session;
* a search for films is available in the "Popular" section;
* when watching popular movies, favorites movies are highlighted;
* progress bars are displayed during long downloads.
  
## Usage example  
  
[Usage example on Google Drive](https://drive.google.com/drive/folders/1Zf42OYkLXG6OvDRkJuzd5VgT23po1ppN?usp=sharing)
  
The first video: an example of a light theme, basic requirements (without showing a description of the film) and additional ones.  
The second video: an example of a dark theme, showing a description of a movie, the ability to share a link to a movie via messengers, an example of a notification about network unavailability.   

  
# Тестовое задание Тинькофф Android Финтех 2023

## Описание задания
Необходимо написать Android-приложение со списком фильмов и их описанием.  
В качестве источника данных используется [неофициальный API кинопоиска](https://kinopoiskapiunofficial.tech/).

## Реализация
Приложение написано на Kotlin.  
Стек: MVVM, Coroutines, Flow, Retrofit 2, Room, Dagger 2, Jetpack Navigation, Glide.

Реализовано:
* отображение списка популярных фильмов в разделе "Популярные", при клике на карточку с фильмом открывается экран с постером фильма, описанием, жанром, страной производства;
* при длительном клике карточка с фильмов добавляется в избранное, отображение списка избранных фильмов в разделе "Избраное";
* уведомление пользователя о том, что сеть недоступна; карточки доступны в оффлайн-режиме;
* в разделе "Популярные" доступен поиск фильмов;
* при просмотре популярных фильмов выделяются фильмы, находящиеся в избранном;
* во время длительных загрузок отображаются прогресс бары.  
  
## Пример использования  
  
[Примеры использования приложения на гугл диске](https://drive.google.com/drive/folders/1Zf42OYkLXG6OvDRkJuzd5VgT23po1ppN?usp=sharing)
  
На первом видео - пример светлой темы, основных требований (без показа описания фильма) и дополнительных.  
На втором видео - пример темной темы, показ описания фильма, возможность поделиться ссылкой на фильм в мессенджерах, пример уведомления о недоступности сети.  
