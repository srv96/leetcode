package me.coding.company.google;

class WebPage {

    String url;
    WebPage back;
    WebPage next;

    public WebPage(String url) {
        this.url = url;
        this.back = null;
        this.next = null;
    }
}

public class BrowserHistory {
    WebPage head, tail, curr;

    public BrowserHistory(String homepage) {
        head = new WebPage("head");
        tail = new WebPage("tail");
        curr = new WebPage(homepage);
        head.next = curr;
        curr.back = head;
        curr.next = tail;
        tail.back = curr;
    }

    public void visit(String url) {
        curr.next = tail;
        tail.back = curr;

        WebPage page = new WebPage(url);
        WebPage lastVisit = tail.back;

        tail.back = page;
        page.next = tail;

        lastVisit.next = page;
        page.back = lastVisit;

        curr = page;
    }

    public String back(int steps) {
        while (!curr.back.url.equals("head") && steps > 0) {
            curr = curr.back;
            steps--;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while (!curr.next.url.equals("tail") && steps > 0) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}
