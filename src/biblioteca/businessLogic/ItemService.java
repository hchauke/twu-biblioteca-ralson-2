package biblioteca.businessLogic;

import biblioteca.library.LibraryManager;
import biblioteca.model.UserAccount;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class ItemService<T> {

    public List<T> listItems() {
        Map<String, T> items = getItemsFromLibrary();

        Map<String, String> checkedItems = getCheckedItemsFromLibrary();

        List<T> itemList = new ArrayList<T>();

        for(String itemId : items.keySet()) {
            if(!checkedItems.containsKey(itemId)) {
                itemList.add(items.get(itemId));
            }
        }
        sortItemList(itemList);
        return itemList;
    }

    public String checkoutItem(String itemId, String readerId) {
        return isExistItem(itemId) && !isCheckedOut(itemId) ?
                saveCheckoutItemToLibrary(itemId, readerId) : getUnsuccessfulCheckoutMessage();
    }

    public String returnCheckedItem(String itemId, String readerId) {
        return isCheckedOut(itemId, readerId) ? returnCheckedItemToLibrary(itemId) : getUnsuccessfulReturnMessage();
    }

    public List<String> listCheckedItems() {

        Map<String, T> items = getItemsFromLibrary();

        Map<String, UserAccount> users = LibraryManager.getUserAccounts();

        Map<String, String> checkedItems = getCheckedItemsFromLibrary();

        List<String> checkedItemInfo = new LinkedList<String>();

        for (String itemId : checkedItems.keySet()) {
            T item = items.get(itemId);
            UserAccount user = users.get(checkedItems.get(itemId));
            checkedItemInfo.add(getItemDescription(item) + " is checked by " + user.getName());
        }
        return checkedItemInfo;
    }

    private boolean isExistItem(String itemId) {
        return getItemsFromLibrary().containsKey(itemId);
    }

    private boolean isCheckedOut(String itemId) {
        return getCheckedItemsFromLibrary().containsKey(itemId);
    }

    private boolean isCheckedOut(String itemId, String readerId) {
        return isCheckedOut(itemId) && getCheckedItemsFromLibrary().containsValue(readerId);
    }

    protected abstract Map<String, T> getItemsFromLibrary();

    protected abstract Map<String, String> getCheckedItemsFromLibrary();

    protected abstract void sortItemList(List<T> itemList);

    protected abstract String saveCheckoutItemToLibrary(String itemId, String readerId);

    protected abstract String returnCheckedItemToLibrary(String itemId);

    protected abstract String getUnsuccessfulCheckoutMessage();

    protected abstract String getUnsuccessfulReturnMessage();

    public abstract String generateItemColumnHeader();

    public abstract String generateItemColumnContent(T item);

    protected abstract String getItemDescription(T item);

}
