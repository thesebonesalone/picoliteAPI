angular.module('PicoLiteMVC.controllers', ['ngSanitize'])
.controller('articlesController', function($scope, articleApiService) {
    $scope.articles = [];

    $scope.shownArticles = [];

    articleApiService.getArticles().then(function(response) {
        $scope.articles = response.data.articles;
    }).finally(() => {
        $scope.update("");
    })

    $scope.update = (filter) => {
        $scope.shownArticles = $scope.articles.filter((e) => {
            return e.title.includes(filter);
        })
    }


})
.controller('articleController', ($scope, $routeParams, articleApiService) => {
    $scope.id = $routeParams.id;
    $scope.articleObject = {article: null}

    articleApiService.getArticle($scope.id).then((resp) => {
        $scope.articleObject.article = resp.data;
    })

    $scope.comments = [];

    $scope.update = function(comment, user)
    {
        $scope.comments.push({comment: comment, name: user});
        $scope.comment = "";
        $scope.user = "";
    }
})