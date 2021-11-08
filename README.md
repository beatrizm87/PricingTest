# PricingTest
L'api Princing permet le calcul du prix d'un produit selon un état et le calcul des prix d'un produit pour tous les états possibles.

# Accès
Vous pouvez accéder à l'API via le lien https://pricing-test-technique.herokuapp.com/

Vous pouvez afficher les donnés de la base de donnés via les liens:

https://pricing-test-technique.herokuapp.com/products

https://pricing-test-technique.herokuapp.com/suppliers

https://pricing-test-technique.herokuapp.com/supplierProducts

# Calculer le prix d'un produit selon un état 
URL à appeler : https://pricing-test-technique.herokuapp.com/pricing/calculateByStatus

<h4>Paramètres</h4>
    <table>
        <tr>
          <th>Paramètre</th>
          <th>Description</th>
        </tr>
        <tr>
          <td>productId</td>
          <td>Id du produit que vous souhaitez vendre</td>
        </tr>
        <tr>
          <td>x</td>
          <td>Quantité de centimes moins cher si son état est le même que celui de son concurrent </td>
        </tr>
        <tr>
          <td>y</td>
          <td>Quantité de centimes moins cher si son état est moins bon que celui de son concurrent </td>
        </tr>
        <tr>
          <td>upperBound</td>
          <td>Prix maximum autorisé pour ce produit s’il n’y a pas de concurrence ou si son état est meilleur que tous les
              concurrents </td>
        </tr>
        <tr>
          <td>lowerBound</td>
          <td>Prix minimum autorisé pour ce produit si le prix calculé descend trop bas</td>
        </tr>
        <tr>
          <td>statusName</td>
          <td>Nom de l'état du produit</td>
        </tr>
      </tbody>
    </table>

<h4>Résultats</h4>
Le prix suggéré selon le produit et l'état.
Ou un message d'erreur.

<h4>Exemple</h4>
https://pricing-test-technique.herokuapp.com/pricing/calculateByStatus?productId=2&x=0.01&y=2&upperBound=29.50&lowerBound=15&statusName=Neuf

# Calculer des prix d'un produit pour tous les états possibles

URL à appeler : https://pricing-test-technique.herokuapp.com/pricing/calculate

<h4>Paramètres</h4>
    <table>
        <tr>
          <th>Paramètre</th>
          <th>Description</th>
        </tr>
        <tr>
          <td>productId</td>
          <td>Id du produit que vous souhaitez vendre</td>
        </tr>
        <tr>
          <td>x</td>
          <td>Quantité de centimes moins cher si son état est le même que celui de son concurrent </td>
        </tr>
        <tr>
          <td>y</td>
          <td>Quantité de centimes moins cher si son état est moins bon que celui de son concurrent </td>
        </tr>
        <tr>
          <td>upperBound</td>
          <td>Prix maximum autorisé pour ce produit s’il n’y a pas de concurrence ou si son état est meilleur que tous les
              concurrents </td>
        </tr>
        <tr>
          <td>lowerBound</td>
          <td>Prix minimum autorisé pour ce produit si le prix calculé descend trop bas</td>
        </tr>
      </tbody>
    </table>

<h4>Résultats</h4>
{"etat moyen":valeur1, "comme neuf":valeur2, "très bon état":valeur3, "bon état":valeur4,"neuf":valeur5}

<h4>Exemple</h4>
https://pricing-test-technique.herokuapp.com/pricing/calculate?productId=2&x=0.01&y=2&upperBound=29.50&lowerBound=15

# Contact

[Beatriz Méndez](https://www.linkedin.com/in/beatrizm87/)

[Send email to Beatriz Méndez](mailto:beatrizm87@gmail.com)

