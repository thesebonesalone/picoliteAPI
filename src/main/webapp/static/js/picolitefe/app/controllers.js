angular.module('PicoLiteMVC.controllers', ['ngSanitize'])
.controller('articlesController', function($scope, articleApiService) {
    $scope.articles = [];

    $scope.shownArticles = [];

    $scope.warning = false;

    $scope.message = "";

    $scope.user = "";
    $scope.comment = "";

    articleApiService.getArticles().then(function(response) {
        $scope.articles = response.data;
        console.log(response)
    }).finally(() => {
        $scope.update("");
    })

    $scope.update = (filter) => {
        $scope.shownArticles = $scope.articles.filter((e) => {
            return e.title.toLowerCase().includes(filter.toLowerCase());
        })
    }
})
.controller('articleController', ($scope, $routeParams, $route, articleApiService) => {
    $scope.id = $routeParams.id;
    $scope.articleObject = {article: null}
    $scope.comments = [];

    articleApiService.getArticle($scope.id).then((resp) => {
        $scope.articleObject.article = resp.data;
        $scope.comments = resp.data.comments;

    })

    $scope.update = function(event)
    {
        if ($scope.user === "" || $scope.comment === "")
        {
            $scope.warning = true;
            $scope.message = "Please fill out required forms!";
            event.preventDefault();
            return;
        }
        data = {
            username: $scope.user,
            content: $scope.comment,
            article_id:$scope.id,
            id: 0
        }
        callback = () => {
            console.log("In callback")
            $scope.$apply(() => {
                $scope.comments.push(
                {
                    user: $scope.user,
                    content: $scope.comment
                })

            $scope.user = "";
            $scope.comment = "";})
        }
        articleApiService.createComment(data,callback)
    }

    $scope.deferWarning = function()
    {
        $scope.warning = false;
        $scope.message = "";
    }
})
.controller('articleEditController', ($scope, $routeParams, $route, $location, articleApiService) =>
{
    $scope.id = $routeParams.id || 0;
    $scope.articleObject = {article: null}
    $scope.content = "";
    $scope.title = "";
    if ($scope.id != 0) {
        articleApiService.getArticle($scope.id).then((resp) => {
            $scope.articleObject.article = resp.data;
            $scope.content = $scope.articleObject.article.content;
            $scope.title = $scope.articleObject.article.title;
        }, (error) => {
            console.log(error)
            $scope.title = "";
            $scope.content = "";
        })
    }

    $scope.showChanges = () => {
        console.log($scope.title)
        console.log($scope.content)
    }

    $scope.submitArticle = (title, content) => {
        data = {
                title: title, content: content, id: $scope.id, game_url: ""

        }
        articleApiService.saveArticle(data, $scope, $location)
    }

    $scope.deleteArticle = () => {
        articleApiService.deleteArticle($location, $scope.id)
    }

})