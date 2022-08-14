angular.module('PicoLiteMVC', ['PicoLiteMVC.controllers', 'PicoLiteMVC.services', 'ngRoute'])
    .config(function($sceDelegateProvider, $routeProvider) {
    $sceDelegateProvider.resourceUrlWhitelist(['self','http://localhost:8081/**']);
    $routeProvider.when("/home", {templateUrl: "static/js/picolitefe/app/templates/home.html", controller: "articlesController"})
        .when("/edit/article/:id", {templateUrl: "static/js/picolitefe/app/templates/articleadd.html", controller: "articlesController"})
        .when("/article/:id", {templateUrl: "static/js/picolitefe/app/templates/article.html", controller: "articlesController"})
        .when("/about", {templateUrl: "static/js/picolitefe/app/templates/about.html"})
        .otherwise({redirectTo: '/home'});
})
