/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learnpi;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/**
 *
 * @author Vicky
 */
public class PiGame extends JPanel{
    
    private boolean play;
    private int score;
    private int stage;
    private String input;
    private String next;
    private boolean lost;
    private String pi;
    
    public PiGame() {
        score = 0;
        stage = 0;
        input = "";
        lost = false;
        next = "";
        pi = "3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006606315588174881520920962829254091715364367892590360011330530548820466521384146951941511609433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949129833673362440656643086021394946395224737190702179860943702770539217176293176752384674818467669405132000568127145263560827785771342757789609173637178721468440901224953430146549585371050792279689258923542019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318595024459455346908302642522308253344685035261931188171010003137838752886587533208381420617177669147303598253490428755468731159562863882353787593751957781857780532171226806613001927876611195909216420198938095257201065485863278865936153381827968230301952035301852968995773622599413891249721775283479131515574857242454150695950829533116861727855889075098381754637464939319255060400927701671139009848824012858361603563707660104710181942955596198946767837449448255379774726847104047534646208046684259069491293313677028989152104752162056966024058038150193511253382430035587640247496473263914199272604269922796782354781636009341721641219924586315030286182974555706749838505494588586926995690927210797509302955321165344987202755960236480665499119881834797753566369807426542527862551818417574672890977772793800081647060016145249192173217214772350141441973568548161361157352552133475741849468438523323907394143334547762416862518983569485562099219222184272550254256887671790494601653466804988627232791786085784383827967976681454100953883786360950680064225125205117392984896084128488626945604241965285022210661186306744278622039194945047123713786960956364371917287467764657573962413890865832645995813390478027590099465764078951269468398352595709825822620522489407726719478268482601476990902640136394437455305068203496252451749399651431429809190659250937221696461515709858387410597885959772975498930161753928468138268683868942774155991855925245953959431049972524680845987273644695848653836736222626099124608051243884390451244136549762780797715691435997700129616089441694868555848406353422072225828488648158456028506016842739452267467678895252138522549954666727823986456596116354886230577456498035593634568174324112515076069479451096596094025228879710893145669136867228748940560101503308617928680920874760917824938589009714909675985261365549781893129784821682998948722658804857564014270477555132379641451523746234364542858444795265867821051141354735739523113427166102135969536231442952484937187110145765403590279934403742007310578539062198387447808478489683321445713868751943506430218453191048481005370614680674919278191197939952061419663428754440643745123718192179998391015919561814675142691239748940907186494231961567945208095146550225231603881930142093762137855956638937787083039069792077346722182562599661501421503068038447734549202605414665925201497442850732518666002132434088190710486331734649651453905796268561005508106658796998163574736384052571459102897064140110971206280439039759515677157700420337869936007230558763176359421873125147120532928191826186125867321579198414";
        play = true;
        System.out.println(pi.length());
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                
                if (!lost && stage == 0 && ((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || (e.getKeyCode() == 46) || (e.getKeyCode() == 32))) {
                    if (e.getKeyCode() != 32) {
                        if (e.getKeyCode() == 46) {
                            input = ".";
                        }
                        else {
                            input = "" + (e.getKeyCode() - 48);
                        }
                        score++;
                        stage = 1;
                        play = false;
                    }
                    else {
                        stage = 2;
                    }
                }
                else if (!lost && stage == 1 && ((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || e.getKeyCode() == 46 || e.getKeyCode() == 32 || e.getKeyCode() == 8)) {
                    if (e.getKeyCode() != 32) {
                        if (e.getKeyCode() == 46) {
                            input += ".";
                        }
                        else if (e.getKeyCode() == 8) {
                            input = input.substring(0, input.length() - 1);
                        }
                        else {
                            input += "" + (e.getKeyCode() - 48);
                        }
                    }
                    else {
                        stage = 2;
                    }
                }
                else if (lost) {
                    lost = false;
                    stage = 0;
                    input = "";
                    score = 0;
                    play = true;
                }
                
                repaint();
            }
        });
        
//        addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//        });
        
    }
    
    public void update(Graphics window) {
        paint(window);
    }
    
    public void paint(Graphics window) {
        
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, 1600, 850);
        
        Font n = new Font(" ", 1, 15);
        window.setFont(n);
        window.setColor(Color.green);
        window.drawString("" + score, 1, 15);
        
        if (play && !lost) {    
            Font number = new Font(" ", 70, 70);
            window.setFont(number);
            next = pi.substring(score, score + 1);
            window.setColor(Color.green);
            window.drawString(next, 800, 800);
        }
        else if (!play && !lost) {
            Font number = new Font(" ", 1, 15);
            window.setFont(number);
            window.setColor(Color.white);
            window.drawString(input, 1, 45);
            window.drawString("" + input.length(), 1, 30);
        }
        
        if (stage == 2) {
            play = true;
            if (!input.equals(pi.substring(0, score))) {
                if (input.length() > score && input.equals(pi.substring(0, input.length()))) {
                    score = input.length();
                }
                else {
                    lost = true;
                }
            }
            input = "";
            stage = 0;
        }
        
        if (lost) {            
            window.setColor(Color.BLACK);
            window.fillRect(0, 0, 1600, 850);
            Font number = new Font(" ", 70, 15);
            window.setFont(number);
            window.setColor(Color.green);
            if (score == 1) {
               window.drawString("Um... do you have short term memory loss?  You can't remember even one.  It's 3", 0, 15); 
            }
            else if (score == 2) {
                window.drawString("Good job!  You recited one digit correctly!", 0, 15);
            }
            else {
                window.drawString("Good job!  You recited " + (score - 1) + " digits correctly!", 0, 15);
            }
        }
        repaint();
    }
    
    
}
