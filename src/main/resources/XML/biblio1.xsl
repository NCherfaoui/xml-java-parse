<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title> Bibliotèque</title>
            </head>
            <body>
                <xsl:for-each select="biblio/etudiant">
                    <li> 
                    Code: <xsl:value-of select="@code"/>
                    </li>
                    <li> 
                        Nom: <xsl:value-of select="@nom"/>
                    </li>
                    <li> 
                        Prénom: <xsl:value-of select="@prenom"/>
                    </li>
                    <table border="1" width="70%">
                        <tr>
                            <th>
                                ID
                            </th>
                            <th>Titre</th>
                            <th>Date</th>
                            <th>Prix</th>
                            <th>Rendu</th>
                        </tr>
                        <xsl:for-each select="livre[@rendu='Non']">
                            <tr>
                                <td><xsl:value-of select="@id"/></td>
                                <td><xsl:value-of select="@titre"/></td>
                                <td><xsl:value-of select="@dateEmprunt"/></td>
                                <td><xsl:value-of select="@prix"/> €</td>
                                <td><xsl:value-of select="@rendu"/></td>
                            </tr>
                        </xsl:for-each>
                        <tr>
                            <td colspan="4"> Nombre de livres empruntés </td>
                            <td><xsl:value-of select="count(livre)"/></td>
                        </tr>
                        <tr>
                            <td colspan="4"> Nombre de livres rendu </td>
                            <td><xsl:value-of select="count(livre[@rendu='Oui'])"/></td>
                        </tr>
                        <tr>
                            <td colspan="4"> Nombre de livres non rendu </td>
                            <td><xsl:value-of select="count(livre[@rendu='Non'])"/></td>
                        </tr>
                        <tr>
                            <td colspan="4"> Total:  </td>
                            <td><xsl:value-of select="sum(livre/@prix)"/> €</td>
                        </tr>
                    </table>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>