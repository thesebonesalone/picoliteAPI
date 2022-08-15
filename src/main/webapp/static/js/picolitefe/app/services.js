angular.module('PicoLiteMVC.services', [])
.factory('articleApiService', function($http) {
    var articleApi = {};
    console.log("This is a test of the JS Bootstrapping")
    articleApi.getArticles = function() {

        var request = {
            method: "GET",
            url: "http://localhost:8081/articles",
            headers: {
                'Content-Type': 'application/json'
            }
        }
        return $http(request);
    }

    articleApi.getArticle = function(id) {
        return $http.get('http://localhost:8081/articles/' + id);
    }
    articleApi.saveArticle = function(data,scope, location) {
        var request = {
            method: "POST",
            url: "http://localhost:8081/articles/",
            headers: {
                'Content-Type': 'application/json'
            },
            data: angular.toJson(data)
        }
        console.log(request)
        $http(request).then((resp) => {
            console.log(resp.data.id)
            scope.id = resp.data.id
            location.path('/article/' + resp.data.id)
        }, () => {
            scope.id = 0;
        })
    }

    articleApi.createComment = function(data, callback)
    {
        var request = {
            method: "POST",
            url: "http://localhost:8081/comments",
            headers: {
                'Content-Type': 'application/json'
            },
            data: angular.toJson(data)

        }
        $http(request).then((resp) => {
            console.log(resp)
            callback;
        }, (err) => {
            console.log("in error")
            console.log(err)
        })
    }

    articleApi.loadComments = function(id) {
        return data = $http.get("http://localhost:8081/comments/article/" + id);
    }

    articleApi.deleteArticle = function(location, id) {
        var request = {
            method: "DELETE",
            url: "http://localhost:8081/articles/" + id
        }
        $http(request).then((resp) => {
            location.path('/home');

        }, ()=> {

        })

    }
    return articleApi;
})